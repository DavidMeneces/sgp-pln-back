package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class AttendAppointmentHandlerTest {

	private final Pipeline pipeline;

	@Inject
	AttendAppointmentHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void handle() {
		UUID id = createAppoinment();
		var request = new AttendAppointmentCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	UUID createAppoinment() {
		UUID id = UUID.randomUUID();
		UUID idPatient = UUID.randomUUID();
		var request = new CreateAppointmentCommand(id, idPatient);
		request.execute(pipeline);
		return id;
	}
}
