package edu.nur.nurtricenter.mealplans.domain.mealplan.event;


import java.time.LocalDateTime;
import java.util.UUID;

public class MealPlanCompletedEvent extends MealPlanIdEvent {

	private final LocalDateTime vCompleteAt;

	public MealPlanCompletedEvent(UUID vId, LocalDateTime vCompleteAt) {
		super(vId);
		this.vCompleteAt = vCompleteAt;
	}

	@Override
	public String getEventName() {
		return "planes.plan-alimetario.completado";
	}

	@Override
	public Object getPayload() {
		return new Payload(vId, vCompleteAt);
	}

	private record Payload(
		UUID id,
		LocalDateTime dateTime) {
	}
}
