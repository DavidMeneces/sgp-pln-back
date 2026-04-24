package edu.nur.nurtricenter.mealplans.application.mealplan;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class MealPlanDto {

	private UUID id;
	private UUID idNutricionist;
	private UUID idPatient;
	private UUID idAppointment;
	private UUID idSubscription;
	private Integer totalDays;
	private LocalDate starDate;
	private LocalDate endDate;
	private BigDecimal totalCalories;
	private List<MealPlanDayDto> mealPlanDays;
	private String transaction;
	private String status;
	private String createBy;
	private LocalDateTime createAt;
}
