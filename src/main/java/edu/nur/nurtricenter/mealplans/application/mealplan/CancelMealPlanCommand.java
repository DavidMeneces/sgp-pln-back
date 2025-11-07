package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record CancelMealPlanCommand(UUID id) implements Command<ResultWithValue<Boolean>> {
}
