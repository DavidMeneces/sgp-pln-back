package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MealPlanCreatedEvent extends MealPlanEvent {

	private final UUID vIdNutricionist;
	private final UUID vIdPatient;
	private final UUID vIdAppointment;
	private final UUID vIdSubscription;
	private final Integer vTotalDays;
	private final LocalDate vStarDate;
	private final LocalDate vEndDate;
	private final BigDecimal vTotalCalories;
	private final List<MealPlanDay> vMealPlanDays;

	public MealPlanCreatedEvent(UUID idMealPlan, UUID vIdNutricionist, UUID vIdPatient, UUID vIdAppointment, UUID vIdSubscription, Integer vTotalDays, LocalDate vStarDate, LocalDate vEndDate, BigDecimal vTotalCalories, List<MealPlanDay> vMealPlanDays) {
		this.vId = idMealPlan;
		this.vIdNutricionist = vIdNutricionist;
		this.vIdPatient = vIdPatient;
		this.vIdAppointment = vIdAppointment;
		this.vIdSubscription = vIdSubscription;
		this.vTotalDays = vTotalDays;
		this.vStarDate = vStarDate;
		this.vEndDate = vEndDate;
		this.vTotalCalories = vTotalCalories;
		this.vMealPlanDays = vMealPlanDays;
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
