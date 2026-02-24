package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;
import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFood;
import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFoodRecipe;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class CreateMealPlanHandlerTest {

    private final Pipeline pipeline;

    @Inject
    CreateMealPlanHandlerTest(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Test
    void handle() {
        var idNutricionist = UUID.fromString("0063b8fd-4e81-464c-be6a-8c4fcac2c6bd");
        var idPatient = UUID.fromString("a172809f-4259-4d8f-82ed-5f2eea93f828");
        var idAppointment = UUID.fromString("a172809f-4259-4d8f-82ed-5f2eea93f828");
        var idSubscription = UUID.fromString("a172809f-4259-4d8f-82ed-5f2eea93f828");
        var totalDays = 15;
        var starDate = LocalDate.parse("2025-01-01");
        var endDate = LocalDate.parse("2025-01-15");
        var totalCalories = BigDecimal.valueOf(100L);
        List<CreateMealPlanCommand.MealPlanDayCommad> mealPlanDays = Arrays.asList(
                new CreateMealPlanCommand.MealPlanDayCommad(1, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(2, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(3, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(4, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(5, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(6, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(7, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(8, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(9, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(10, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(11, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(12, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(13, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(14, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                )),
                new CreateMealPlanCommand.MealPlanDayCommad(15, Arrays.asList(
                        new CreateMealPlanCommand.TimeFoodCommad(TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                new CreateMealPlanCommand.TimeFoodRecipeCommand(UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338"), 1)
                        ))
                ))
        );
        var request = new CreateMealPlanCommand(idNutricionist, idPatient, idAppointment, idSubscription, totalDays, starDate, endDate, totalCalories, mealPlanDays);
        var response = request.execute(pipeline);
        Assertions.assertNotNull(response.getValue());
    }
}