package edu.nur.nurtricenter.mealplans.application.patient;

import static org.junit.jupiter.api.Assertions.*;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreatePatientHandlerTest {

	private final Pipeline pipeline;

	@Inject
	CreatePatientHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void handle() {
		UUID id = UUID.randomUUID();
		String name = "David Meneces";
		var request = new CreatePatientCommand(id, name);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
