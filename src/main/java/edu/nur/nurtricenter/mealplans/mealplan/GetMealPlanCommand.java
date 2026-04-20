package edu.nur.nurtricenter.mealplans.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import java.util.UUID;

public record GetMealPlanCommand(UUID id) implements Command<ResultWithValue<MealPlanDto>> {}
