package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateRecipeCommand(String name, String description, String instructions, BigDecimal totalCalories, List<RecipeIngredientCommand> ingredients) implements Command<ResultWithValue<UUID>> {

    public record RecipeIngredientCommand(UUID idIngredient, Integer quantity) {
    }
}
