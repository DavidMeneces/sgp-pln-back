package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class GetPatientAppointmentsHandlerTest {

	private final Pipeline pipeline;

	@Inject
	GetPatientAppointmentsHandlerTest(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@Test
	void getSuccessful() {
		var idPatient = UUID.fromString("e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32");
		var request = new GetPatientAppointmentsCommand(idPatient, "ATENDIDO", 0, 10);
		var response = request.execute(pipeline);
		System.out.println("response.getValue() = " + response.getValue());
		Assertions.assertNotNull(response.getValue());
	}
}
