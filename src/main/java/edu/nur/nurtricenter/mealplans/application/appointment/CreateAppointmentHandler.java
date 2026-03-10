package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.AppointmentModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateAppointmentHandler
		implements Command.Handler<CreateAppointmentCommand, ResultWithValue<Boolean>> {

	private AppointmentModelRepository repository;

	public CreateAppointmentHandler(AppointmentModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<Boolean> handle(CreateAppointmentCommand command) {
		AppointmentModel model =
				AppointmentModel.builder().id(command.id()).idPatient(command.idPatient()).build();
		repository.save(model);
		return ResultWithValue.success(Boolean.TRUE);
	}
}
