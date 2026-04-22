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
class GetRecipeByIdHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetRecipeByIdHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void found() {
		var id = createRecipe();
		var request = new GetRecipeByIdCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	private UUID createRecipe() {
		var name = "r1";
		var description = "ir1";
		var instructions = "ii1";
		var totalCalories = BigDecimal.valueOf(100L);
		var ingredients =
				List.of(
						new CreateRecipeCommand.RecipeIngredientCommand(
								UUID.fromString("504f49db-0c26-486e-b037-6775666efc91"), 1));
		var request =
				new CreateRecipeCommand(
						name, description, instructions, totalCalories, ingredients);
		var response = request.execute(pipeline);
		return response.getValue();
	}

	@Test
	void notFound() {
		var id = UUID.fromString("408ed13f-31d3-4987-9bd1-531dc19b47eb");
		var request = new GetRecipeByIdCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found recipe", response.getError().getDescription());
	}
}
