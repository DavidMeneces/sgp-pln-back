package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record UpdateMealPlanCommand(UUID id) implements Command<ResultWithValue<Boolean>> {
}
