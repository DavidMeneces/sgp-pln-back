package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CancelMealPlanHandlerTest {

	private final Pipeline pipeline;

	@Inject
	CancelMealPlanHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void cancelSuccessful() {
		var id = createMealPlan();
		var request = new CancelMealPlanCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	private UUID createMealPlan() {
		var idNutricionist = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idPatient = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idAppointment = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var idSubscription = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var totalDays = 15;
		var starDate = LocalDate.parse("2025-01-01");
		var endDate = LocalDate.parse("2025-01-15");
		var totalCalories = BigDecimal.valueOf(100L);
		List<CreateMealPlanCommand.MealPlanDayCommad> mealPlanDays =
				Arrays.asList(
						new CreateMealPlanCommand.MealPlanDayCommad(
								1,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								2,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								3,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								4,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								5,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								6,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								7,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								8,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								9,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								10,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								11,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								12,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								13,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								14,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))),
						new CreateMealPlanCommand.MealPlanDayCommad(
								15,
								Arrays.asList(
										new CreateMealPlanCommand.TimeFoodCommad(
												TimeFoodEnum.BREAKFAST,
												1,
												Arrays.asList(
														new CreateMealPlanCommand
																.TimeFoodRecipeCommand(
																UUID.fromString(
																		"e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32"),
																1))))));
		var request =
				new CreateMealPlanCommand(
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
		return response.getValue();
	}
}
