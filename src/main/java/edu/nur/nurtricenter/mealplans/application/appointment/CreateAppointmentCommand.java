package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import java.util.UUID;

public record CreateAppointmentCommand(
		@JsonProperty("citaId") UUID id, @JsonProperty("pacienteId") UUID idPatient)
		implements Command<ResultWithValue<Boolean>> {}
