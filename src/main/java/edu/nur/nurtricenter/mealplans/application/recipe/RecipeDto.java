package edu.nur.nurtricenter.mealplans.application.recipe;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {

	private UUID id;
	private String name;
	private String description;
	private String instructions;
	private BigDecimal totalCalories;
	private List<RecipeIngredientDto> ingredients;
	private String transaction;
	private String status;
	private String createBy;
	private LocalDateTime createAt;
}
