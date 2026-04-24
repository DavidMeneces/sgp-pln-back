package edu.nur.nurtricenter.mealplans.core.abstractions;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AggregateRoot extends Entity {

	protected String transaction;
	protected String status;
	protected String createBy;
	protected LocalDateTime createAt;

	protected AggregateRoot(UUID id) {
		super(id);
	}

	public String getTransaction() {
		return transaction;
	}

	public String getStatus() {
		return status;
	}

	public String getCreateBy() {
		return createBy;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}
}
