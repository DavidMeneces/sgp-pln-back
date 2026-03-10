package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetRecipeHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetRecipeHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void found() {
		var id = UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338");
		var request = new GetRecipeCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	@Test
	void notFound() {
		var id = UUID.fromString("408ed13f-31d3-4987-9bd1-531dc19b47eb");
		var request = new GetRecipeCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found recipe", response.getError().getDescription());
	}
}
