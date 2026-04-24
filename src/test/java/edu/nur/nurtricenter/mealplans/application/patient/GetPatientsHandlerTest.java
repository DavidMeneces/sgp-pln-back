package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetPatientsHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetPatientsHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var request = new GetPatientsCommand(0, 10);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
