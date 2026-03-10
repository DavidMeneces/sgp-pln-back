package edu.nur.nurtricenter.mealplans.core.abstractions;

import java.util.UUID;

public interface IRepository<T extends AggregateRoot> {

	T getById(UUID id, boolean readOnly);

	boolean existById(UUID id);

	UUID add(T entity);
}
