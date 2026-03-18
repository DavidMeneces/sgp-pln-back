package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AttendAppointmentHandlerTest {

	private final Pipeline pipeline;

	@Inject
	AttendAppointmentHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void attendSuccessful() {
		UUID id = createAppoinment();
		var request = new AttendAppointmentCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertNotNull(response.getValue());
	}

	private UUID createAppoinment() {
		UUID id = UUID.randomUUID();
		UUID idPatient = UUID.randomUUID();
		var request = new CreateAppointmentCommand(id, idPatient);
		request.execute(pipeline);
		return id;
	}

	@Test
	void notFound() {
		UUID id = UUID.fromString("408ed13f-31d3-4987-9bd1-531dc19b47eb");
		var request = new AttendAppointmentCommand(id);
		var response = request.execute(pipeline);
		Assertions.assertEquals("Not found appointment", response.getError().getDescription());
	}
}
