package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;

import java.util.List;
import java.util.UUID;

public record GetPatientAppointmentsCommand(UUID idPatient, String status, Integer page, Integer size) implements Command<ResultWithValue<List<AppointmentModel>>> {
}
