package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.PatientModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPatientsHandler
	implements Command.Handler<GetPatientsCommand, ResultWithValue<List<PatientModel>>> {

	private PatientModelRepository repository;

	public GetPatientsHandler(PatientModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<List<PatientModel>> handle(GetPatientsCommand command) {
		var models = (List<PatientModel>) repository.findAll(command.size(), command.page());
		return ResultWithValue.success(models);
	}
}
