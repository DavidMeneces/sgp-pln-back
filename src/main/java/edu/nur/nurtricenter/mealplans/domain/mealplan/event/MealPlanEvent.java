package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;

import java.util.UUID;

public abstract class MealPlanEvent extends DomainEvent {
	protected UUID vId;

	@Override
	public String getAggregateType() {
		return "MealPlan";
	}

	@Override
	public String getAggregateId() {
		return vId.toString();
	}
}
