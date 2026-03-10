package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MealPlanDayTest {

	@Test
	void create() {
		// Arrange
		UUID id = UUID.randomUUID();
		Integer day = 1;
		List<TimeFood> timeFoods =
				List.of(
						TimeFood.create(
								UUID.randomUUID(),
								TimeFoodEnum.BREAKFAST,
								1,
								List.of(
										TimeFoodRecipe.create(
												UUID.randomUUID(), UUID.randomUUID(), 1))));
		// Act
		MealPlanDay mealPlanDay = MealPlanDay.create(id, day, timeFoods);
		// Assert
		Assertions.assertEquals(id, mealPlanDay.getId());
		Assertions.assertEquals(day, mealPlanDay.getDay());
		Assertions.assertEquals(timeFoods, mealPlanDay.getTimeFoods());
	}

	@Test
	void createExceptionId() {
		// Arrange
		UUID id = null;
		Integer day = 1;
		List<TimeFood> timeFoods =
				List.of(
						TimeFood.create(
								UUID.randomUUID(),
								TimeFoodEnum.BREAKFAST,
								1,
								List.of(
										TimeFoodRecipe.create(
												UUID.randomUUID(), UUID.randomUUID(), 1))));
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> MealPlanDay.create(id, day, timeFoods));

		// Assert
		Assertions.assertEquals("Id cannot be null", exception.getMessage());
	}

	@Test
	void createExceptionDay() {
		// Arrange
		UUID id = UUID.randomUUID();
		Integer day = null;
		List<TimeFood> timeFoods =
				List.of(
						TimeFood.create(
								UUID.randomUUID(),
								TimeFoodEnum.BREAKFAST,
								1,
								List.of(
										TimeFoodRecipe.create(
												UUID.randomUUID(), UUID.randomUUID(), 1))));
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> MealPlanDay.create(id, day, timeFoods));

		// Assert
		Assertions.assertEquals("day cannot be null", exception.getMessage());
	}

	@Test
	void createExceptionTimeFoods() {
		// Arrange
		UUID id = UUID.randomUUID();
		Integer day = 1;
		List<TimeFood> timeFoods = null;
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> MealPlanDay.create(id, day, timeFoods));
		// Assert
		Assertions.assertEquals("timeFoods cannot be null or empty", exception.getMessage());
	}
}
