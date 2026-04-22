package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.List;

public record GetIngredientsCommand(Integer page, Integer size) implements Command<ResultWithValue<List<IngredientDto>>> {}
