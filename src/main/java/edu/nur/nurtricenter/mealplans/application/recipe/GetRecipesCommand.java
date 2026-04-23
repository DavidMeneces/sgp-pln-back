package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.List;

public record GetRecipesCommand(Integer page, Integer size) implements Command<ResultWithValue<List<RecipeDto>>> {
}
