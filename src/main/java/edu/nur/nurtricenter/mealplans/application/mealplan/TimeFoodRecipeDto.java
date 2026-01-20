package edu.nur.nurtricenter.mealplans.application.mealplan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeFoodRecipeDto {
    private UUID id;
    private UUID idRecipe;
    private Integer portion;
}
