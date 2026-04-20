package edu.nur.nurtricenter.mealplans.domain.mealplan.event;


import java.time.LocalDateTime;
import java.util.UUID;

public class MealPlanCancelledEvent extends MealPlanIdEvent {

	private final LocalDateTime vDateTime;

	public MealPlanCancelledEvent(UUID vId, LocalDateTime vDateTime) {
		super(vId);
		this.vDateTime = vDateTime;
	}

	@Override
	public String getEventName() {
		return "planes.plan-alimetario.cancelado";
	}

	@Override
	public Object getPayload() {
		return new Payload(vId, vDateTime);
	}

	private record Payload(
		UUID id,
		LocalDateTime dateTime) {
	}
}
