package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimeFoodTest {

	@Test
	void create() {
		// Arrange
		UUID id = UUID.randomUUID();
		TimeFoodEnum type = TimeFoodEnum.BREAKFAST;
		Integer order = 1;
		List<TimeFoodRecipe> recipes =
				List.of(TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1));
		// Act
		TimeFood timeFood = TimeFood.create(id, type, order, recipes);
		// Assert
		Assertions.assertEquals(id, timeFood.getId());
		Assertions.assertEquals(type, timeFood.getType());
		Assertions.assertEquals(order, timeFood.getOrder());
		Assertions.assertEquals(recipes, timeFood.getRecipes());
	}

	@Test
	void createExceptionId() {
		// Arrange
		UUID id = null;
		TimeFoodEnum type = TimeFoodEnum.BREAKFAST;
		Integer order = 1;
		List<TimeFoodRecipe> recipes =
				List.of(TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1));
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFood.create(id, type, order, recipes));

		// Assert
		Assertions.assertEquals("Id cannot be null", exception.getMessage());
	}

	@Test
	void createExceptionType() {
		// Arrange
		UUID id = UUID.randomUUID();
		TimeFoodEnum type = null;
		Integer order = 1;
		List<TimeFoodRecipe> recipes =
				List.of(TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1));
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFood.create(id, type, order, recipes));

		// Assert
		Assertions.assertEquals("type cannot be null", exception.getMessage());
	}

	@Test
	void createExceptionOrder() {
		// Arrange
		UUID id = UUID.randomUUID();
		TimeFoodEnum type = TimeFoodEnum.BREAKFAST;
		Integer order = null;
		List<TimeFoodRecipe> recipes =
				List.of(TimeFoodRecipe.create(UUID.randomUUID(), UUID.randomUUID(), 1));
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFood.create(id, type, order, recipes));

		// Assert
		Assertions.assertEquals("order cannot be null or minor equal zero", exception.getMessage());
	}

	@Test
	void createExceptionRecipes() {
		// Arrange
		UUID id = UUID.randomUUID();
		TimeFoodEnum type = TimeFoodEnum.BREAKFAST;
		Integer order = 1;
		List<TimeFoodRecipe> recipes = null;
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFood.create(id, type, order, recipes));

		// Assert
		Assertions.assertEquals("recipes cannot be null or empty", exception.getMessage());
	}
}
