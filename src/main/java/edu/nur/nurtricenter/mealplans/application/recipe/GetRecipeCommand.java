package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record GetRecipeCommand(UUID id) implements Command<ResultWithValue<RecipeDto>>  {
}
