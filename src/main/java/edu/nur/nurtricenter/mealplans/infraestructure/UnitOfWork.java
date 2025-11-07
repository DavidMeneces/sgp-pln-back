package edu.nur.nurtricenter.mealplans.infraestructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import edu.nur.nurtricenter.mealplans.core.abstractions.Entity;
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

    public UnitOfWork(EntityManager em, Pipeline pipeline) {
        this.em = em;
        this.pipeline = pipeline;
    }

    public void register(Entity entity) {
        registeredEntities.add(entity);
    }

    @Override
    @Async
    @Transactional
    public CompletableFuture<Void> commitAsync() {
        this.em.flush();
        List<DomainEvent> domainEvents = registeredEntities.stream()
                .filter(e -> !e.getDomainEvents().isEmpty())
                .flatMap(e -> {
                    List<DomainEvent> events = new ArrayList<>(e.getDomainEvents());
                    e.clearDomainEvents();
                    return events.stream();
                })
                .toList();
        for (DomainEvent domainEvent : domainEvents) {
            domainEvent.send(pipeline);
        }
        registeredEntities.clear();
        return CompletableFuture.completedFuture(null);
    }
}
