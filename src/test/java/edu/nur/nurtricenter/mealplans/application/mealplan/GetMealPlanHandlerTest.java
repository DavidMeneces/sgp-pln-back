package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.mealplan.GetMealPlanCommand;
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
	void found() {
		var id = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var request = new GetMealPlanCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	@Test
	void notFoud() {
		var id = UUID.fromString("29f23f19-fa8e-481f-aecd-716650e79930");
		var request = new GetMealPlanCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNull(response.getValue());
	}
}
