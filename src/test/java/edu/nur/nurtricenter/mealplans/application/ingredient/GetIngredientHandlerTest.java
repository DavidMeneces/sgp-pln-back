package edu.nur.nurtricenter.mealplans.application.ingredient;

import static org.junit.jupiter.api.Assertions.*;

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
	void handle() {
		var id = UUID.fromString("c8aa1d9b-ba79-477c-87bd-df96e00579f6");
		var request = new GetIngredientCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
