package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
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
	void fund() {
		var id = UUID.fromString("c8aa1d9b-ba79-477c-87bd-df96e00579f6");
		var request = new GetIngredientCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	@Test
	void notFound() {
		var id = UUID.fromString("d855d236-b493-4c4a-8795-ce031296f342");
		var request = new GetIngredientCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found ingredient", response.getError().getDescription());
	}
}
