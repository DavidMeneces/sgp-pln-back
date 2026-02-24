package edu.nur.nurtricenter.mealplans.infraestructure;

import java.util.*;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nur.nurtricenter.mealplans.core.abstractions.Entity;
import edu.nur.nurtricenter.mealplans.infraestructure.outbox.OutboxEventEntity;
import edu.nur.nurtricenter.mealplans.infraestructure.outbox.OutboxEventMapper;
import edu.nur.nurtricenter.mealplans.infraestructure.outbox.OutboxEventRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;
import edu.nur.nurtricenter.mealplans.core.abstractions.IUnitOfWork;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class UnitOfWork implements IUnitOfWork {
    private final EntityManager em;
    private final Pipeline pipeline;
    private final Set<Entity> registeredEntities = new HashSet<>();

    private final OutboxEventRepository outboxRepository;
    private final OutboxEventMapper mapper;

    public UnitOfWork(EntityManager em, Pipeline pipeline, OutboxEventRepository outboxRepository, ObjectMapper objectMapper) {
        this.em = em;
        this.pipeline = pipeline;
        this.outboxRepository = outboxRepository;
        this.mapper = new OutboxEventMapper(objectMapper);
    }

    public void register(Entity entity) {
        registeredEntities.add(entity);
    }

    @Override
    @Async
    @Transactional
    public CompletableFuture<Void> commitAsync(Entity... entities) {
        this.em.flush();
        List<DomainEvent> domainEvents = Arrays.stream(entities).toList().stream()
                .filter(e -> !e.getDomainEvents().isEmpty())
                .flatMap(e -> {
                    List<DomainEvent> events = new ArrayList<>(e.getDomainEvents());
                    e.clearDomainEvents();
                    return events.stream();
                })
                .toList();
        if (!domainEvents.isEmpty()) {
            List<OutboxEventEntity> outboxEventEntities = domainEvents.stream()
                    .map(mapper::toEntity)
                    .toList();
            outboxRepository.saveAll(outboxEventEntities);
        }
        registeredEntities.clear();
        return CompletableFuture.completedFuture(null);
    }
}
