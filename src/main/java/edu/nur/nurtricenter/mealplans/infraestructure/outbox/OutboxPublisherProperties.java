package edu.nur.nurtricenter.mealplans.infraestructure.outbox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbitmq")
public class OutboxPublisherProperties {
	private String host;
	private int port = 5672;
	private String username;
	private String password;
	private String vhost = "/";
	private String exchange;
	private String exchangeType = "fanout";
	private boolean exchangeDurable = true;
	private String routingKey;
	private String queue;
	private boolean queueDurable = true;
	private boolean queueExclusive = false;
	private boolean queueAutoDelete = false;
	private String bindingKey = "";
	private boolean declareTopology = false;
	private int publishRetries = 3;
	private long publishBackoffMs = 250;
	private int connectTimeoutSeconds = 3;
	private int readWriteTimeoutSeconds = 3;
	private int outboxBatchSize = 50;
	private long outboxPollIntervalMs = 1000;
}
