package edu.nur.nurtricenter.mealplans.application.mealplan;

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
public class MealPlanDayDto {

    private UUID id;
    private Integer day;
    private List<TimeFoodDto> timeFoods;
}
