package edu.nur.nurtricenter.mealplans.application.ingredient;

import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
	private UUID id;
	private String name;
	private String description;
	private UnitMeasureEnum unitMeasure;
	private BigDecimal caloriesPerGram;
	private String transaction;
	private String status;
	private String createBy;
	private LocalDateTime createAt;
}
