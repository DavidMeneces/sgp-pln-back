package edu.nur.nurtricenter.mealplans.application.nutricionist;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.NutricionistModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.NutricionistModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateNutritionistHandler implements Command.Handler<CreateNutritionistCommand, ResultWithValue<Boolean>> {

	private NutricionistModelRepository repository;

	public CreateNutritionistHandler(NutricionistModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<Boolean> handle(CreateNutritionistCommand command) {
		NutricionistModel model = NutricionistModel.builder()
			.id(command.id())
			.name(command.name() + " " + command.lastName())
			.status("HABILITADO")
			.build();
		repository.save(model);
		return ResultWithValue.success(Boolean.TRUE);
	}
}
