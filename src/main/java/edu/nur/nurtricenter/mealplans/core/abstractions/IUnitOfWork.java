package edu.nur.nurtricenter.mealplans.core.abstractions;

import java.util.concurrent.CompletableFuture;

public interface IUnitOfWork {
    CompletableFuture<Void> commitAsync(Entity... entities);
}