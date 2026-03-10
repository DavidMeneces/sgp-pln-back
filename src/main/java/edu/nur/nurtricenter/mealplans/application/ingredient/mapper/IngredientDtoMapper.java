package edu.nur.nurtricenter.mealplans.application.ingredient.mapper;

import edu.nur.nurtricenter.mealplans.application.ingredient.IngredientDto;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;

public final class IngredientDtoMapper {

	public static IngredientDto mapper(Ingredient ingredient) {
		return IngredientDto.builder()
				.id(ingredient.getId())
				.name(ingredient.getName())
				.description(ingredient.getDescription())
				.unitMeasure(ingredient.getUnitMeasure())
				.caloriesPerGram(ingredient.getCaloriesPerGram())
				.build();
	}
}
