package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CreateMealPlanCommand(
		UUID idNutricionist,
		UUID idPatient,
		UUID idAppointment,
		UUID idSubscription,
		Integer totalDays,
		LocalDate starDate,
		LocalDate endDate,
		BigDecimal totalCalories,
		List<MealPlanDayCommad> mealPlanDays)
		implements Command<ResultWithValue<UUID>> {
	public record MealPlanDayCommad(Integer day, List<TimeFoodCommad> timeFoods) {}

	public record TimeFoodCommad(
			TimeFoodEnum type, Integer order, List<TimeFoodRecipeCommand> recipes) {}

	public record TimeFoodRecipeCommand(UUID idRecipe, Integer portion) {}
}
