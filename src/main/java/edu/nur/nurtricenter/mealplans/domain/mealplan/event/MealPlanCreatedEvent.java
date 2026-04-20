package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MealPlanCreatedEvent extends MealPlanEvent {

	public MealPlanCreatedEvent(UUID vId, UUID vIdNutricionist, UUID vIdPatient, UUID vIdAppointment, UUID vIdSubscription, Integer vTotalDays, LocalDate vStarDate, LocalDate vEndDate, BigDecimal vTotalCalories, List<MealPlanDay> vMealPlanDays) {
		super(vId, vIdNutricionist, vIdPatient, vIdAppointment, vIdSubscription, vTotalDays, vStarDate, vEndDate, vTotalCalories, vMealPlanDays);
	}

	@Override
	public String getEventName() {
		return "planes.plan-alimetario.creado";
	}

	@Override
	public Object getPayload() {
		return new Payload(vId, vIdNutricionist, vIdPatient, vIdAppointment, vIdSubscription, vTotalDays, vStarDate, vEndDate, vTotalCalories, vMealPlanDays);
	}

	private record Payload(
			UUID id,
			UUID idNutricionist,
			UUID idPatient,
			UUID idAppointment,
			UUID idSubscription,
			Integer totalDays,
			LocalDate starDate,
			LocalDate endDate,
			BigDecimal totalCalories,
			List<MealPlanDay> mealPlanDays) {
	}
}
