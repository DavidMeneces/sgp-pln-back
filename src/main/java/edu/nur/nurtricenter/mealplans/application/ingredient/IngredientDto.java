package edu.nur.nurtricenter.mealplans.application.ingredient;

import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

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
}
