package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public abstract class MealPlanEvent extends MealPlanIdEvent {
	protected final UUID vIdNutricionist;
	protected final UUID vIdPatient;
	protected final UUID vIdAppointment;
	protected final UUID vIdSubscription;
	protected final Integer vTotalDays;
	protected final LocalDate vStarDate;
	protected final LocalDate vEndDate;
	protected final BigDecimal vTotalCalories;
	protected final List<MealPlanDay> vMealPlanDays;

	protected MealPlanEvent(UUID vId, UUID vIdNutricionist, UUID vIdPatient, UUID vIdAppointment, UUID vIdSubscription, Integer vTotalDays, LocalDate vStarDate, LocalDate vEndDate, BigDecimal vTotalCalories, List<MealPlanDay> vMealPlanDays) {
		super(vId);
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
}
