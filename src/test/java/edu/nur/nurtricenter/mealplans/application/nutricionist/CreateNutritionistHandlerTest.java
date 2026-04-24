package edu.nur.nurtricenter.mealplans.application.nutricionist;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateNutritionistHandlerTest {

	private final Pipeline pipeline;

	@Inject
	CreateNutritionistHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void createSuccessful() {
		UUID id = UUID.randomUUID();
		String name = "David";
		String lastName = "Meneces";
		var request = new CreateNutritionistCommand(id, name, lastName);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
