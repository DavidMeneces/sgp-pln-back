package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class MealPlanCancelledEvent extends DomainEvent {

	private UUID id;
	private LocalDateTime dateTime;

	public MealPlanCancelledEvent(
		UUID id,
		LocalDateTime dateTime) {
		this.id = id;
		this.dateTime = dateTime;
	}

	@Override
	public UUID getId() {
		return id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public String getAggregateType() {
		return "MealPlan";
	}

	@Override
	public String getAggregateId() {
		return id.toString();
	}

	@Override
	public String getEventName() {
		return "planes.plan-alimetario.cancelado";
	}

	@Override
	public Object getPayload() {
		return new Payload(
			id,
			dateTime);
	}

	private record Payload(
		UUID id,
		LocalDateTime dateTime) {
	}
}
