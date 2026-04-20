package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MealPlanUpdatedEvent extends DomainEvent {

	private UUID idMealPlan;
	private UUID idNutricionist;
	private UUID idPatient;
	private UUID idAppointment;
	private UUID idSubscription;
	private Integer totalDays;
	private LocalDate starDate;
	private LocalDate endDate;
	private BigDecimal totalCalories;
	private List<MealPlanDay> mealPlanDays;

	public MealPlanUpdatedEvent(UUID idMealPlan, UUID idNutricionist, UUID idPatient, UUID idAppointment, UUID idSubscription, Integer totalDays, LocalDate starDate, LocalDate endDate, BigDecimal totalCalories, List<MealPlanDay> mealPlanDays) {
		this.idMealPlan = idMealPlan;
		this.idNutricionist = idNutricionist;
		this.idPatient = idPatient;
		this.idAppointment = idAppointment;
		this.idSubscription = idSubscription;
		this.totalDays = totalDays;
		this.starDate = starDate;
		this.endDate = endDate;
		this.totalCalories = totalCalories;
		this.mealPlanDays = mealPlanDays;
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
		return "planes.plan-alimetario.actualizado";
	}

	@Override
	public Object getPayload() {
		return new Payload(idMealPlan, idNutricionist, idPatient, idAppointment, idSubscription, totalDays, starDate, endDate, totalCalories, mealPlanDays);
	}

	private record Payload(UUID id, UUID idNutricionist, UUID idPatient, UUID idAppointment, UUID idSubscription,
						Integer totalDays, LocalDate starDate, LocalDate endDate, BigDecimal totalCalories,
						List<MealPlanDay> mealPlanDays) {
	}
}
