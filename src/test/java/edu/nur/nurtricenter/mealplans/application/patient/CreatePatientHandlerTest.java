package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.CreateIngredientCommand;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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
