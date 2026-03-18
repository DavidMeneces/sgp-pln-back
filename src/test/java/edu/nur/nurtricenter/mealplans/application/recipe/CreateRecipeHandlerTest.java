package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateRecipeHandlerTest {

	private final Pipeline pipeline;

	@Inject
	CreateRecipeHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void createSuccessful() {
		var name = "r1";
		var description = "ir1";
		var instructions = "ii1";
		var totalCalories = BigDecimal.valueOf(100L);
		var ingredients =
				List.of(
						new CreateRecipeCommand.RecipeIngredientCommand(
								UUID.fromString("504f49db-0c26-486e-b037-6775666efc91"), 1));
		// Request
		var request =
				new CreateRecipeCommand(
						name, description, instructions, totalCalories, ingredients);
		// Response
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	@Test
	void createWithNoIndredients() {
		var name = "r1";
		var description = "ir1";
		var instructions = "ii1";
		var totalCalories = BigDecimal.valueOf(100L);
		List<CreateRecipeCommand.RecipeIngredientCommand> ingredients = null;
		// Request
		var request =
				new CreateRecipeCommand(
						name, description, instructions, totalCalories, ingredients);
		// Response
		IllegalArgumentException exception =
				Assertions.assertThrows(
						IllegalArgumentException.class, () -> request.execute(pipeline));
		Assertions.assertEquals("ingredients cannot be null or empty", exception.getMessage());
	}
}
