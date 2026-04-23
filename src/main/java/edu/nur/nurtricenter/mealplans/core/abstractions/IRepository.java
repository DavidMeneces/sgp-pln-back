package edu.nur.nurtricenter.mealplans.core.abstractions;

import java.util.List;
import java.util.UUID;

public interface IRepository<T extends AggregateRoot> {

	List<T> get(Integer page, Integer size);

	T getById(UUID id, boolean readOnly);

	boolean existById(UUID id);

	UUID add(T entity);
}
