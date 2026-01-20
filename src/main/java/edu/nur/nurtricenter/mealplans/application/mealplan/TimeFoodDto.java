package edu.nur.nurtricenter.mealplans.application.mealplan;

import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFoodRecipe;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeFoodDto {

    private UUID id;
    private TimeFoodEnum type;
    private Integer order;
    private List<TimeFoodRecipeDto> recipes;
}
