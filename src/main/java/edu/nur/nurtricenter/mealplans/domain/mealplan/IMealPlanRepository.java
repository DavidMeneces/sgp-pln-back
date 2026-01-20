package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.core.abstractions.IRepository;

import java.util.UUID;

public interface IMealPlanRepository extends IRepository<MealPlan> {
    boolean existById(UUID id, String status);
    void cancelById(UUID id);
    void update(MealPlan item);
    void delete(UUID id);
}
