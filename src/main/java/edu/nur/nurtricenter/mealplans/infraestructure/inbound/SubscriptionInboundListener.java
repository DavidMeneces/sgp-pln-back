package edu.nur.nurtricenter.mealplans.infraestructure.inbound;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nur.nurtricenter.mealplans.core.results.ErrorType;
import edu.nur.nurtricenter.mealplans.core.results.Result;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class SubscriptionInboundListener {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionInboundListener.class);

    private final Pipeline pipeline;
    private final ObjectMapper objectMapper;
    private final InboundSubscriptionProperties props;
    private final InboundEventMetrics metrics;

    public SubscriptionInboundListener(
            Pipeline pipeline,
            ObjectMapper objectMapper,
            InboundSubscriptionProperties props,
            InboundEventMetrics metrics
    ) {
        this.pipeline = pipeline;
        this.objectMapper = objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.props = props;
        this.metrics = metrics;
    }

    @RabbitListener(queues = "${inbound.rabbitmq.queue:planes.inbound}")
    public void onMessage(Message message) {
        log.info("Message received: {}", message);
        try {
            String body = new String(message.getBody(), StandardCharsets.UTF_8);
            Map<String, Object> bodyMessage = objectMapper.readValue(body, new TypeReference<Map<String, Object>>() {
            });
            log.info("Body message received {}", bodyMessage);

            String routingKey = message.getMessageProperties() != null
                    ? message.getMessageProperties().getReceivedRoutingKey()
                    : null;
            log.info("Routing key received {}", routingKey);

            String eventName = readString(bodyMessage, "event", "event_name", "eventName");
            if (eventName == null || eventName.isBlank()) {
                throw new AmqpRejectAndDontRequeueException("Missing event field");
            }

            Map<String, Object> payload = extractPayloadRequired(bodyMessage);
            log.info("Payload received: {}", payload);

            UUID eventId = readRequiredUuid(bodyMessage, "event_id", "eventId");
            UUID correlationId = readRequiredUuid(bodyMessage, "correlation_id", "correlationId");
            Integer schemaVersion = readRequiredInt(bodyMessage, "schema_version", "schemaVersion");
            validateSchemaVersion(schemaVersion);
            String occurredOn = readRequiredString(bodyMessage, "occurred_on", "occurredOn");
            validateOccurredOn(occurredOn);
            metrics.incrementReceived(eventName);
            try (MDC.MDCCloseable ignoredCorrelation = putMdc("correlation_id", correlationId != null ? correlationId.toString() : null);
                 MDC.MDCCloseable ignoredEventId = putMdc("event_id", eventId != null ? eventId.toString() : null)) {
                var commandEvent = InboundEventCommand.findByEventName(eventName);
                if (commandEvent != null) {
                    log.info("Command event founded {}", commandEvent);
                    var command = objectMapper.convertValue(payload, commandEvent);
                    var result = (ResultWithValue<?>) pipeline.send(command);
                    if (result.isFailure()) {
                        log.warn("Inbound subscription event failed: event={} error={}", eventName, result.getError().getDescription());
                        if (result.getError().getType() == ErrorType.VALIDATION || result.getError().getType() == ErrorType.CONFLICT || result.getError().getType() == ErrorType.NOT_FOUND) {
                            throw new AmqpRejectAndDontRequeueException(result.getError().getDescription());
                        }
                        throw new IllegalStateException(result.getError().getDescription());
                    }
                    log.info("Command {} executed success", command);
                }
            }
        } catch (AmqpRejectAndDontRequeueException ex) {
            throw ex;
        } catch (IllegalStateException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Inbound subscription message parse failure", ex);
            throw new AmqpRejectAndDontRequeueException("Inbound message rejected", ex);
        }
    }

    private MDC.MDCCloseable putMdc(String key, String value) {
        if (value == null || value.isBlank()) {
            return MDC.putCloseable(key, "");
        }
        return MDC.putCloseable(key, value);
    }

    private void validateSchemaVersion(Integer schemaVersion) {
        List<Integer> allowed = props.getSchemaVersions();
        if (allowed == null || allowed.isEmpty()) {
            return;
        }
        if (!allowed.contains(schemaVersion)) {
            throw new AmqpRejectAndDontRequeueException("Unsupported schema_version: " + schemaVersion);
        }
    }

    private void validateOccurredOn(String occurredOn) {
        try {
            OffsetDateTime.parse(occurredOn);
        } catch (DateTimeParseException ex) {
            throw new AmqpRejectAndDontRequeueException("Invalid occurred_on format");
        }
    }

    private UUID readRequiredUuid(Map<String, Object> values, String... keys) {
        String raw = readRequiredString(values, keys);
        try {
            return UUID.fromString(raw);
        } catch (IllegalArgumentException ex) {
            throw new AmqpRejectAndDontRequeueException("Invalid UUID field");
        }
    }

    private Integer readRequiredInt(Map<String, Object> values, String... keys) {
        Integer value = readInt(values, keys);
        if (value == null) {
            throw new AmqpRejectAndDontRequeueException("Missing integer field");
        }
        return value;
    }

    private String readRequiredString(Map<String, Object> values, String... keys) {
        String raw = readString(values, keys);
        if (raw == null || raw.isBlank()) {
            throw new AmqpRejectAndDontRequeueException("Missing required field");
        }
        return raw;
    }

    private Integer readInt(Map<String, Object> values, String... keys) {
        for (String key : keys) {
            Object value = values.get(key);
            if (value == null) {
                continue;
            }
            if (value instanceof Integer i) {
                return i;
            }
            if (value instanceof Number n) {
                return n.intValue();
            }
            if (value instanceof String s && !s.isBlank()) {
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException ex) {
                    throw new AmqpRejectAndDontRequeueException("Invalid integer field");
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> extractPayloadRequired(Map<String, Object> parsed) {
        Object payload = parsed.get("payload");
        if (payload instanceof Map<?, ?> mapPayload) {
            return (Map<String, Object>) mapPayload;
        }
        throw new AmqpRejectAndDontRequeueException("Missing payload object");
    }

    private String readString(Map<String, Object> values, String... keys) {
        for (String key : keys) {
            Object value = values.get(key);
            if (value instanceof String str && !str.isBlank()) {
                return str;
            }
        }
        return null;
    }
}
