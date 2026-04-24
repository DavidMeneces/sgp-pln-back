package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.AppointmentModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPatientAppointmentsHandler
	implements Command.Handler<GetPatientAppointmentsCommand, ResultWithValue<List<AppointmentModel>>> {

	private AppointmentModelRepository repository;

	public GetPatientAppointmentsHandler(AppointmentModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<List<AppointmentModel>> handle(GetPatientAppointmentsCommand command) {
		var models = (List<AppointmentModel>) repository.findAllByPatient(command.idPatient(), command.status(), command.size(), command.page());
		return ResultWithValue.success(models);
	}
}
