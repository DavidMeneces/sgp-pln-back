package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.PatientModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreatePatientHandler
		implements Command.Handler<CreatePatientCommand, ResultWithValue<Boolean>> {

	private PatientModelRepository repository;

	public CreatePatientHandler(PatientModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<Boolean> handle(CreatePatientCommand command) {
		PatientModel model = PatientModel.builder().id(command.id()).name(command.name()).build();
		repository.save(model);
		return ResultWithValue.success(Boolean.TRUE);
	}
}
