package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class UpdateMealPlanHandlerTest {

	private final Pipeline pipeline;

	@Inject
	UpdateMealPlanHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	@Rollback
	void updateSuccessful() {
		var id = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idNutricionist = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idPatient = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idAppointment = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idSubscription = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<UpdateMealPlanCommand.MealPlanDayCommad> mealPlanDays =
			Arrays.asList(
				new UpdateMealPlanCommand.MealPlanDayCommad(
					1,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					2,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					3,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					4,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					5,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					6,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					7,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					8,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					9,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					10,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					11,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					12,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					13,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					14,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))),
				new UpdateMealPlanCommand.MealPlanDayCommad(
					15,
					Arrays.asList(
						new UpdateMealPlanCommand.TimeFoodCommad(
							TimeFoodEnum.BREAKFAST,
							1,
							Arrays.asList(
								new UpdateMealPlanCommand
									.TimeFoodRecipeCommand(
									UUID.fromString(
										"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
									1))))));
		var request =
			new UpdateMealPlanCommand(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	@Test
	void notFoundMealPlan() {
		var id = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idNutricionist = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idPatient = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idAppointment = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idSubscription = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<UpdateMealPlanCommand.MealPlanDayCommad> mealPlanDays = null;
		var request =
			new UpdateMealPlanCommand(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found meal-plan", response.getError().getDescription());
	}

	@Test
	void notFoundNutricionist() {
		var id = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idNutricionist = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idPatient = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idAppointment = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idSubscription = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<UpdateMealPlanCommand.MealPlanDayCommad> mealPlanDays = null;
		var request =
			new UpdateMealPlanCommand(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found nutritionist", response.getError().getDescription());
	}

	@Test
	void notFoundPatient() {
		var id = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idNutricionist = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idPatient = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idAppointment = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idSubscription = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<UpdateMealPlanCommand.MealPlanDayCommad> mealPlanDays = null;
		var request =
			new UpdateMealPlanCommand(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found patient", response.getError().getDescription());
	}

	@Test
	void notFoundAppoitment() {
		var id = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idNutricionist = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idPatient = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idAppointment = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var idSubscription = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<UpdateMealPlanCommand.MealPlanDayCommad> mealPlanDays = null;
		var request =
			new UpdateMealPlanCommand(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found appointment", response.getError().getDescription());
	}

	@Test
	void notFoundSuscriptionType() {
		var id = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idNutricionist = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idPatient = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idAppointment = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idSubscription = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<UpdateMealPlanCommand.MealPlanDayCommad> mealPlanDays = null;
		var request =
			new UpdateMealPlanCommand(
				id,
				idNutricionist,
				idPatient,
				idAppointment,
				idSubscription,
				totalDays,
				starDate,
				endDate,
				totalCalories,
				mealPlanDays);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found subscription type", response.getError().getDescription());
	}
}
