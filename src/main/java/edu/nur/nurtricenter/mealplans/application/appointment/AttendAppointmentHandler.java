package edu.nur.nurtricenter.mealplans.application.appointment;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.AppointmentModelRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class AttendAppointmentHandler
		implements Command.Handler<AttendAppointmentCommand, ResultWithValue<Boolean>> {

	private AppointmentModelRepository repository;

	public AttendAppointmentHandler(AppointmentModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<Boolean> handle(AttendAppointmentCommand command) {
		Optional<AppointmentModel> result = repository.findById(command.id());
		if (result.isEmpty()) {
			return ResultWithValue.validationFailure(
					Error.notFound("NotFound", "Not found appointment", command.id().toString()));
		}
		AppointmentModel model = result.get();
		model.setStatus("ATENDIDO");
		repository.save(model);
		return ResultWithValue.success(Boolean.TRUE);
	}
}
