package edu.nur.nurtricenter.mealplans.application.mealplan.mapper;

import edu.nur.nurtricenter.mealplans.application.mealplan.MealPlanDayDto;
import edu.nur.nurtricenter.mealplans.application.mealplan.MealPlanDto;
import edu.nur.nurtricenter.mealplans.application.mealplan.TimeFoodDto;
import edu.nur.nurtricenter.mealplans.application.mealplan.TimeFoodRecipeDto;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;
import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFood;
import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFoodRecipe;

import java.util.List;

public final class MealPlanDtoMapper {

    public static MealPlanDto mapper(MealPlan mealPlan) {
        return MealPlanDto.builder()
                .id(mealPlan.getId())
                .idNutricionist(mealPlan.getIdNutricionist())
                .idPatient(mealPlan.getIdPatient())
                .idAppointment(mealPlan.getIdAppointment())
                .idSubscription(mealPlan.getIdSubscription())
                .totalDays(mealPlan.getTotalDays())
                .starDate(mealPlan.getStarDate())
                .endDate(mealPlan.getEndDate())
                .totalCalories(mealPlan.getTotalCalories())
                .mealPlanDays(mapperMealPlanDays(mealPlan.getMealPlanDays()))
                .build();
    }

    private static List<MealPlanDayDto> mapperMealPlanDays(List<MealPlanDay> mealPlanDays) {
        return mealPlanDays != null ? mealPlanDays.stream().map(mealPlanDay -> MealPlanDayDto.builder()
                .id(mealPlanDay.getId())
                .day(mealPlanDay.getDay())
                .timeFoods(mapperTimeFoods(mealPlanDay.getTimeFoods()))
                .build()).toList() : null;
    }

    private static List<TimeFoodDto> mapperTimeFoods(List<TimeFood> timeFoods) {
        return timeFoods != null ? timeFoods.stream().map(timeFood -> TimeFoodDto.builder()
                .id(timeFood.getId())
                .type(timeFood.getType())
                .order(timeFood.getOrder())
                .recipes(mapperTimeFoodsRecipies(timeFood.getRecipes()))
                .build()).toList() : null;
    }

    private static List<TimeFoodRecipeDto> mapperTimeFoodsRecipies(List<TimeFoodRecipe> recipes) {
        return recipes != null ? recipes.stream().map(recipe -> TimeFoodRecipeDto.builder()
                .id(recipe.getId())
                .idRecipe(recipe.getIdRecipe())
                .portion(recipe.getPortion())
                .build()).toList() : null;
    }
}
