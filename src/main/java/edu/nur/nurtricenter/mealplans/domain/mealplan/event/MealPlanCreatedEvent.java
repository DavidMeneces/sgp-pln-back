package edu.nur.nurtricenter.mealplans.domain.mealplan.event;

import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class MealPlanCreatedEvent extends DomainEvent {

	private UUID id;
	private UUID idNutricionist;
	private UUID idPatient;
	private UUID idAppointment;
	private UUID idSubscription;
	private Integer totalDays;
	private LocalDate starDate;
	private LocalDate endDate;
	private BigDecimal totalCalories;
	private List<MealPlanDay> mealPlanDays;

	public MealPlanCreatedEvent(
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
		this.id = id;
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
	public UUID getId() {
		return id;
	}

	public UUID getIdNutricionist() {
		return idNutricionist;
	}

	public UUID getIdPatient() {
		return idPatient;
	}

	public UUID getIdAppointment() {
		return idAppointment;
	}

	public UUID getIdSubscription() {
		return idSubscription;
	}

	public Integer getTotalDays() {
		return totalDays;
	}

	public LocalDate getStarDate() {
		return starDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public BigDecimal getTotalCalories() {
		return totalCalories;
	}

	public List<MealPlanDay> getMealPlanDays() {
		return mealPlanDays;
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
		return "planes.plan-alimetario.creado";
	}

	@Override
	public Object getPayload() {
		return new Payload(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
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
			List<MealPlanDay> mealPlanDays) {}
}
