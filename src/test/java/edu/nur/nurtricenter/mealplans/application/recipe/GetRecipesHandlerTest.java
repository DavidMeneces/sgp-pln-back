package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetRecipesHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetRecipesHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var request = new GetRecipesCommand(0, 10);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
