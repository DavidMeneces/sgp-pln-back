package edu.nur.nurtricenter.mealplans.application.subscription;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record CreateSubscriptionTypeCommand(
	@JsonProperty("suscripcionId") UUID id,
	@JsonProperty("nombre") String name,
	@JsonProperty("cantidadDias") Integer days)
	implements Command<ResultWithValue<Boolean>> {
}
