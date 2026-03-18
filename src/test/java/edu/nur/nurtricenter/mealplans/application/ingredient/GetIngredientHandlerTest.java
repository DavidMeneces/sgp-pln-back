package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetIngredientHandlerTest {

	private final Pipeline pipeline;

	@Inject
	public GetIngredientHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void fundSuccessful() {
		var id = createIngredient();
		var request = new GetIngredientCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	private UUID createIngredient() {
		String name = "i1";
		String description = "di1";
		UnitMeasureEnum unitMeasure = UnitMeasureEnum.GRAM;
		BigDecimal caloriesPerGram = BigDecimal.valueOf(150L);
		var request = new CreateIngredientCommand(name, description, unitMeasure, caloriesPerGram);
		var response = request.execute(pipeline);
		return response.getValue();
	}

	@Test
	void notFound() {
		var id = UUID.fromString("d855d236-b493-4c4a-8795-ce031296f342");
		var request = new GetIngredientCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found ingredient", response.getError().getDescription());
	}
}
