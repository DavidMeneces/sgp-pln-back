package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetMealPlansHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetMealPlansHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var request = new GetMealPlansCommand(0, 10);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
