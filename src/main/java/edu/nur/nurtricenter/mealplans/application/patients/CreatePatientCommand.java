package edu.nur.nurtricenter.mealplans.application.patients;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.UUID;

public record CreatePatientCommand(UUID patientId, String nombre) implements Command<ResultWithValue<Boolean>> {
}
