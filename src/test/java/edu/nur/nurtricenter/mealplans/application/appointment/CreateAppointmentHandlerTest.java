package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateAppointmentHandlerTest {

	private final Pipeline pipeline;

	@Inject
	CreateAppointmentHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void createSuccessful() {
		UUID id = UUID.randomUUID();
		UUID idPatient = UUID.randomUUID();
		var request = new CreateAppointmentCommand(id, idPatient);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}
}
