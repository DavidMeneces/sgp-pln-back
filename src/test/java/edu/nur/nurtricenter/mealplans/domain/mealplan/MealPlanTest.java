package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@SpringBootTest
class MealPlanTest {

    @Test
    void createMealPlanValid() {
        //Arrange
        UUID id = UUID.randomUUID();
        UUID idNutricionist = UUID.randomUUID();
        UUID idPatient = UUID.randomUUID();
        Integer totalDays = 15;
        LocalDate starDate = LocalDate.parse("2025-01-01");
        LocalDate endDate = LocalDate.parse("2025-01-15");
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = Arrays.asList(
                MealPlanDay.create(UUID.randomUUID(), 1, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 2, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 3, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 4, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 5, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 6, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 7, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 8, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 9, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 10, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 11, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 12, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 13, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 14, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                )),
                MealPlanDay.create(UUID.randomUUID(), 15, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                ))
        );
        //Act
        MealPlan mealPlan = MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays);
        //Assert
        Assertions.assertEquals(id, mealPlan.getId());
        Assertions.assertEquals(idNutricionist, mealPlan.getIdNutricionist());
        Assertions.assertEquals(idPatient, mealPlan.getIdPatient());
        Assertions.assertEquals(totalDays, mealPlan.getTotalDays());
        Assertions.assertEquals(starDate, mealPlan.getStarDate());
        Assertions.assertEquals(endDate, mealPlan.getEndDate());
        Assertions.assertEquals(totalCalories, mealPlan.getTotalCalories());
        Assertions.assertEquals(mealPlanDays, mealPlan.getMealPlanDays());
    }

    @Test
    void createMealPlanExceptionId() {
        //Arrange
        UUID id = null;
        UUID idNutricionist = UUID.randomUUID();
        UUID idPatient = UUID.randomUUID();
        Integer totalDays = 15;
        LocalDate starDate = LocalDate.parse("2025-01-01");
        LocalDate endDate = LocalDate.parse("2025-01-15");
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = Arrays.asList(
                MealPlanDay.create(UUID.randomUUID(), 1, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                ))
        );
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays)
        );
        //Assert
        Assertions.assertEquals("id cannot be null", exception.getMessage());
    }

    @Test
    void createMealPlanExceptionIdNutricionist() {
        //Arrange
        UUID id = UUID.randomUUID();
        UUID idNutricionist = null;
        UUID idPatient = UUID.randomUUID();
        Integer totalDays = 15;
        LocalDate starDate = LocalDate.parse("2025-01-01");
        LocalDate endDate = LocalDate.parse("2025-01-15");
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = Arrays.asList(
                MealPlanDay.create(UUID.randomUUID(), 1, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                ))
        );
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays)
        );
        //Assert
        Assertions.assertEquals("idNutricionist cannot be null", exception.getMessage());
    }

    @Test
    void createMealPlanExceptionIdPatient() {
        //Arrange
        UUID id = UUID.randomUUID();
        UUID idNutricionist = UUID.randomUUID();
        UUID idPatient = null;
        Integer totalDays = 15;
        LocalDate starDate = LocalDate.parse("2025-01-01");
        LocalDate endDate = LocalDate.parse("2025-01-15");
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = Arrays.asList(
                MealPlanDay.create(UUID.randomUUID(), 1, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                ))
        );
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays)
        );
        //Assert
        Assertions.assertEquals("idPatient cannot be null", exception.getMessage());
    }

    @Test
    void createMealPlanExceptionTotalDays() {
        //Arrange
        UUID id = UUID.randomUUID();
        UUID idNutricionist = UUID.randomUUID();
        UUID idPatient = UUID.randomUUID();
        Integer totalDays = 0;
        LocalDate starDate = LocalDate.parse("2025-01-01");
        LocalDate endDate = LocalDate.parse("2025-01-15");
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = Arrays.asList(
                MealPlanDay.create(UUID.randomUUID(), 1, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                ))
        );
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays)
        );
        //Assert
        Assertions.assertEquals("totalDays value must not be zero and must be 15 or 30", exception.getMessage());
    }

    @Test
    void createMealPlanExceptionStarDate() {
        //Arrange
        UUID id = UUID.randomUUID();
        UUID idNutricionist = UUID.randomUUID();
        UUID idPatient = UUID.randomUUID();
        Integer totalDays = 15;
        LocalDate starDate = null;
        LocalDate endDate = null;
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = Arrays.asList(
                MealPlanDay.create(UUID.randomUUID(), 1, Arrays.asList(
                        TimeFood.create(UUID.randomUUID(), TimeFoodEnum.BREAKFAST, 1, Arrays.asList(
                                TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1)
                        ))
                ))
        );
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays)
        );
        //Assert
        Assertions.assertEquals("starDate cannot be null", exception.getMessage());
    }

    @Test
    void createMealPlanExceptionMealPlanDays() {
        //Arrange
        UUID id = UUID.randomUUID();
        UUID idNutricionist = UUID.randomUUID();
        UUID idPatient = UUID.randomUUID();
        Integer totalDays = 15;
        LocalDate starDate = LocalDate.parse("2025-01-01");
        LocalDate endDate = LocalDate.parse("2025-01-15");
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<MealPlanDay> mealPlanDays = null;
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> MealPlan.create(id, idNutricionist, idPatient, totalDays, starDate, endDate, totalCalories, mealPlanDays)
        );
        //Assert
        Assertions.assertEquals("mealPlanDays cannot be null and must be same size to totalDays", exception.getMessage());
    }

}