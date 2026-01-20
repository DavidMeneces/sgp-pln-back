package edu.nur.nurtricenter.mealplans.application.mealplan;

import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealPlanDto {

    private UUID id;
    private UUID idNutricionist;
    private UUID idPatient;
    private Integer totalDays;
    private LocalDate starDate;
    private LocalDate endDate;
    private BigDecimal totalCalories;
    private List<MealPlanDayDto> mealPlanDays;
}
