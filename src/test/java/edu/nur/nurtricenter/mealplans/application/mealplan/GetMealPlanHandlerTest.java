package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetMealPlanHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetMealPlanHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void handle() {
		var id = UUID.fromString("eeddc777-bf89-4755-a671-70aef39df2ab");
		var request = new GetMealPlanCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	@Test
	void handleNotFoud() {
		var id = UUID.fromString("eeddc777-bf89-4755-a671-70aef39df2ac");
		var request = new GetMealPlanCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNull(response.getValue());
	}
}
