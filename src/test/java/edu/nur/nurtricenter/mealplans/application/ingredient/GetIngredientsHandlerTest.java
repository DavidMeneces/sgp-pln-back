package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetIngredientsHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetIngredientsHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var request = new GetIngredientsCommand(0, 10);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
