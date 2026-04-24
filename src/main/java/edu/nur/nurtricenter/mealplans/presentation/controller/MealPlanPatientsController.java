package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.patient.GetPatientAppointmentsCommand;
import edu.nur.nurtricenter.mealplans.application.patient.GetPatientsCommand;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/meal-plans/patients")
public class MealPlanPatientsController {

	private final Pipeline pipeline;

	public MealPlanPatientsController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@GetMapping("")
	public ResultWithValue<List<PatientModel>> get(@RequestParam(required = false, defaultValue = "0") int page,
												@RequestParam(required = false, defaultValue = "10") int size) {
		var command = new GetPatientsCommand(page, size);
		log.info("[GET] get {}", command);
		return command.execute(pipeline);
	}

	@GetMapping("/{id}/appointments")
	public ResultWithValue<List<AppointmentModel>> getAppointment(@PathVariable UUID id,
																@RequestParam(required = false, defaultValue = "0") int page,
																@RequestParam(required = false, defaultValue = "10") int size,
																@RequestParam(required = false, defaultValue = "ATENDIDO") String status) {
		var command = new GetPatientAppointmentsCommand(id, status, page, size);
		log.info("[GET] get {}", command);
		return command.execute(pipeline);
	}
}
