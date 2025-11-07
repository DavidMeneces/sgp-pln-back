package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.core.abstractions.IRepository;

import java.util.UUID;

public interface IMealPlanRepository extends IRepository<MealPlan> {
    void update(MealPlan item);
    void delete(UUID id);
}
