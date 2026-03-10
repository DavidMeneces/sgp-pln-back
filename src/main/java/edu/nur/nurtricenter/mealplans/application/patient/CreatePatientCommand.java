package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import java.util.UUID;

public record CreatePatientCommand(
		@JsonProperty("pacienteId") UUID id, @JsonProperty("nombre") String name)
		implements Command<ResultWithValue<Boolean>> {}
