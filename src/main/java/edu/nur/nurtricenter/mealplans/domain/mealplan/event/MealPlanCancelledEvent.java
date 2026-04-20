package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class MealPlanCancelledEvent extends DomainEvent {

	private UUID idMealPlan;
	private LocalDateTime dateTime;

	public MealPlanCancelledEvent(UUID idMealPlan, LocalDateTime dateTime) {
		this.idMealPlan = idMealPlan;
		this.dateTime = dateTime;
	}

	@Override
	public String getAggregateType() {
		return "MealPlan";
	}

	@Override
	public String getAggregateId() {
		return idMealPlan.toString();
	}

	@Override
	public String getEventName() {
		return "planes.plan-alimetario.cancelado";
	}

	@Override
	public Object getPayload() {
		return new Payload(idMealPlan, dateTime);
	}

	private record Payload(
		UUID id,
		LocalDateTime dateTime) {
	}
}
