package edu.nur.nurtricenter.mealplans.application.recipe.mapper;

import edu.nur.nurtricenter.mealplans.application.recipe.RecipeDto;
import edu.nur.nurtricenter.mealplans.application.recipe.RecipeIngredientDto;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.domain.recipe.RecipeIngredient;
import java.util.List;

public final class ReciperDtoMapper {

	public static RecipeDto mapper(Recipe recipe) {
		return RecipeDto.builder()
				.id(recipe.getId())
				.name(recipe.getName())
				.description(recipe.getDescription())
				.instructions(recipe.getInstructions())
				.totalCalories(recipe.getTotalCalories())
				.ingredients(mapperIngredients(recipe.getIngredients()))
				.build();
	}

	public static List<RecipeIngredientDto> mapperIngredients(List<RecipeIngredient> ingredientes) {
		return ingredientes.stream()
				.map(
						ingredient ->
								RecipeIngredientDto.builder()
										.idIngredient(ingredient.getIdIngredient())
										.quantity(ingredient.getQuantity())
										.build())
				.toList();
	}
}
