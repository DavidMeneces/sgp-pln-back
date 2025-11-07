package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.mealplan.*;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanDayModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodRecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MealPlanRepository implements IMealPlanRepository {

    @Autowired
    MealPlanModelRepository repository;
    @Autowired
    MealPlanDayModelRepository mealPlanDayModelRepository;
    @Autowired
    TimeFoodModelRepository timeFoodModelRepository;
    @Autowired
    TimeFoodRecipeModelRepository timeFoodRecipeModelRepository;

    @Override
    public MealPlan getById(UUID id, boolean readOnly) {
        return null;
    }

    @Override
    public UUID add(MealPlan entity) {
        var model = MealPlanModel.buildModel(entity);
        repository.save(model);
        addMealPlanDay(model.getId(), entity.getMealPlanDays());
        return entity.getId();
    }

    protected void addMealPlanDay(UUID id, List<MealPlanDay> mealPlanDays) {
        for (MealPlanDay mealPlanDay : mealPlanDays) {
            MealPlanDayModel model = MealPlanDayModel.buildModel(id, mealPlanDay);
            mealPlanDayModelRepository.save(model);
            addTimeFood(model.getId(), mealPlanDay.getTimeFoods());
        }
    }

    protected void addTimeFood(UUID id, List<TimeFood> timeFoods) {
        for (TimeFood timeFood : timeFoods) {
            TimeFoodModel model = TimeFoodModel.buildModel(id, timeFood);
            timeFoodModelRepository.save(model);
            addTimeFoodRecipe(model.getId(), timeFood.getRecipes());
        }
    }

    protected void addTimeFoodRecipe(UUID id, List<TimeFoodRecipe> timeFoodsRecipes) {
        for (TimeFoodRecipe timeFoodRecipe : timeFoodsRecipes) {
            TimeFoodRecipeModel model = TimeFoodRecipeModel.buildModel(id, timeFoodRecipe);
            timeFoodRecipeModelRepository.save(model);
        }
    }

    @Override
    public void update(MealPlan item) {

    }

    @Override
    public void delete(UUID id) {

    }
}
