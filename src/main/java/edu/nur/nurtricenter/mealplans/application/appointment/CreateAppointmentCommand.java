package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record CreatePatientCommand(UUID id, String name) implements Command<ResultWithValue<Boolean>> {
}
