package edu.nur.nurtricenter.mealplans.mealplan;

import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
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
public class TimeFoodDto {

	private UUID id;
	private TimeFoodEnum type;
	private Integer order;
	private List<TimeFoodRecipeDto> recipes;
}
