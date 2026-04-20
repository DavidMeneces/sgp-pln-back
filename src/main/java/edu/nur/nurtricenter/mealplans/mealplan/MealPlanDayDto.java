package edu.nur.nurtricenter.mealplans.mealplan;

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
public class MealPlanDayDto {

	private UUID id;
	private Integer day;
	private List<TimeFoodDto> timeFoods;
}
