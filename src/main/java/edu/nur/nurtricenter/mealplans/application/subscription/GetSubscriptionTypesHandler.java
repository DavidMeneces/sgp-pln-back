package edu.nur.nurtricenter.mealplans.application.subscription;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SubscriptionTypeModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.SubscriptionTypeModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSubscriptionTypesHandler
	implements Command.Handler<GetSubscriptionTypesCommand, ResultWithValue<List<SubscriptionTypeModel>>> {

	private SubscriptionTypeModelRepository repository;

	public GetSubscriptionTypesHandler(SubscriptionTypeModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<List<SubscriptionTypeModel>> handle(GetSubscriptionTypesCommand command) {
		var models = (List<SubscriptionTypeModel>) repository.findAll(command.size(), command.page());
		return ResultWithValue.success(models);
	}
}
