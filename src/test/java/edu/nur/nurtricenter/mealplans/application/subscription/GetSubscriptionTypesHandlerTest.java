package edu.nur.nurtricenter.mealplans.application.subscription;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetSubscriptionTypesHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetSubscriptionTypesHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var request = new GetSubscriptionTypesCommand(0, 10);
		var response = request.execute(pipeline);
		System.out.println("response.getValue() = " + response.getValue());
		Assertions.assertNotNull(response.getValue());
	}
}
