package edu.nur.nurtricenter.mealplans.application.recipe;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDto {

	private UUID idIngredient;
	private Integer quantity;
}
