package edu.nur.nurtricenter.mealplans.domain.mealplan;


import edu.nur.nurtricenter.mealplans.core.abstractions.AggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

public class MealPlan extends AggregateRoot {

    private UUID idNutricionist;
    private UUID idPatient;
    private UUID idAppointment;
    private UUID idSubscription;
    private Integer totalDays;
    private LocalDate starDate;
    private LocalDate endDate;
    private BigDecimal totalCalories;
    private List<MealPlanDay> mealPlanDays;

    public MealPlan() {
        super(UUID.randomUUID());
    }

    public MealPlan(UUID id, UUID idNutricionist, UUID idPatient, UUID idAppointment, UUID idSubscription, Integer totalDays, LocalDate starDate, LocalDate endDate, BigDecimal totalCalories, List<MealPlanDay> mealPlanDays) {
        super(id);
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

    public static MealPlan create(UUID id, UUID idNutricionist, UUID idPatient, UUID idAppointment, UUID idSubscription, Integer totalDays, LocalDate starDate, LocalDate endDate, BigDecimal totalCalories, List<MealPlanDay> mealPlanDays) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (idNutricionist == null) {
            throw new IllegalArgumentException("idNutricionist cannot be null");
        }
        if (idPatient == null) {
            throw new IllegalArgumentException("idPatient cannot be null");
        }
        if (idAppointment == null) {
            throw new IllegalArgumentException("idAppointment cannot be null");
        }
        if (idSubscription == null) {
            throw new IllegalArgumentException("idSubscription cannot be null");
        }
        if (totalDays == null || !(totalDays == 15 || totalDays == 30)) {
            throw new IllegalArgumentException("totalDays value must not be zero and must be 15 or 30");
        }
        if (starDate == null) {
            throw new IllegalArgumentException("starDate cannot be null");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("endDate cannot be null");
        }
        if (starDate.compareTo(endDate) >= 0) {
            throw new IllegalArgumentException("The start date must be earlier than the end date");
        }
        long difDays = ChronoUnit.DAYS.between(starDate, endDate) + 1;
        if (!(difDays == 15 || difDays == 30)) {
            throw new IllegalArgumentException("difDays value must be 15 or 30");
        }
        if (mealPlanDays == null || mealPlanDays.size() != totalDays) {
            throw new IllegalArgumentException("mealPlanDays cannot be null and must be same size to totalDays");
        }
        return new MealPlan(id, idNutricionist, idPatient, idAppointment, idSubscription, totalDays, starDate, endDate, totalCalories, mealPlanDays);
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

    public List<MealPlanDay> getMealPlanDays() {
        return mealPlanDays;
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
}
