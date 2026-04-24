package edu.nur.nurtricenter.mealplans.application.nutricionist;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.NutricionistModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.NutricionistModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetNutritionistsHandler
	implements Command.Handler<GetNutritionistsCommand, ResultWithValue<List<NutricionistModel>>> {

	private NutricionistModelRepository repository;

	public GetNutritionistsHandler(NutricionistModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<List<NutricionistModel>> handle(GetNutritionistsCommand command) {
		var models = (List<NutricionistModel>) repository.findAll(command.size(), command.page());
		return ResultWithValue.success(models);
	}
}
