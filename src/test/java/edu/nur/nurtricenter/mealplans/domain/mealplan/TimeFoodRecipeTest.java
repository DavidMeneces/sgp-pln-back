package edu.nur.nurtricenter.mealplans.domain.mealplan;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimeFoodRecipeTest {

	@Test
	void create() {
		// Arrange
		UUID id = UUID.randomUUID();
		UUID idRecipe = UUID.randomUUID();
		Integer portion = 1;
		// Act
		TimeFoodRecipe timeFoodRecipe = TimeFoodRecipe.create(id, idRecipe, portion);
		// Assert
		Assertions.assertEquals(id, timeFoodRecipe.getId());
		Assertions.assertEquals(idRecipe, timeFoodRecipe.getIdRecipe());
		Assertions.assertEquals(portion, timeFoodRecipe.getPortion());
	}

	@Test
	void createExceptionId() {
		// Arrange
		UUID id = null;
		UUID idRecipe = UUID.randomUUID();
		Integer portion = 1;
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFoodRecipe.create(id, idRecipe, portion));

		// Assert
		Assertions.assertEquals("id cannot be null", exception.getMessage());
	}

	@Test
	void createExceptionIdRecipe() {
		// Arrange
		UUID id = UUID.randomUUID();
		UUID idRecipe = null;
		Integer portion = 1;
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFoodRecipe.create(id, idRecipe, portion));

		// Assert
		Assertions.assertEquals("idRecipe cannot be null", exception.getMessage());
	}

	@Test
	void createExceptionPortion() {
		// Arrange
		UUID id = UUID.randomUUID();
		UUID idRecipe = UUID.randomUUID();
		Integer portion = null;
		// Act
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class,
						() -> TimeFoodRecipe.create(id, idRecipe, portion));

		// Assert
		Assertions.assertEquals(
				"portion cannot be null or minor equal zero", exception.getMessage());
	}
}
