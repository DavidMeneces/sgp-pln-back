package edu.nur.nurtricenter.mealplans.core.abstractions;

import java.util.UUID;

public interface IRepository<T extends AggregateRoot> {

    T getById(UUID id, boolean readOnly);

    UUID add(T entity);
}