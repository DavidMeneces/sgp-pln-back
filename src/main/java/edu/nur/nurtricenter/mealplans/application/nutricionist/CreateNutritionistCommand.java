package edu.nur.nurtricenter.mealplans.application.nutricionist;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record CreateNutritionistCommand(
	@JsonProperty("nutricionistaId") UUID id,
	@JsonProperty("nombre") String name,
	@JsonProperty("apellido") String lastName)
	implements Command<ResultWithValue<Boolean>> {
}
