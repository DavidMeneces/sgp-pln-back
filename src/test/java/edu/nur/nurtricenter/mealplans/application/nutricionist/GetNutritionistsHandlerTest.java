package edu.nur.nurtricenter.mealplans.application.nutricionist;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetNutritionistsHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetNutritionistsHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var request = new GetNutritionistsCommand(0, 10);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
