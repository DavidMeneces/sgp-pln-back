package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record AttendAppointmentCommand (@JsonProperty("citaId") UUID id) implements Command<ResultWithValue<Boolean>> {
}
