package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import java.util.UUID;

public record GetIngredientByIdCommand(UUID id) implements Command<ResultWithValue<IngredientDto>> {}
