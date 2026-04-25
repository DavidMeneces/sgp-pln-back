package edu.nur.nurtricenter.mealplans.application.subscription;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateSubscriptionTypeHandlerTest {

	private final Pipeline pipeline;

	@Inject
	CreateSubscriptionTypeHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void createSuccessful() {
		UUID id = UUID.randomUUID();
		String name = "Quincenal";
		var request = new CreateSubscriptionTypeCommand(id, name, 15);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
