package edu.nur.nurtricenter.mealplans.application.subscription;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SubscriptionTypeModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.SubscriptionTypeModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateSubscriptionTypeHandler implements Command.Handler<CreateSubscriptionTypeCommand, ResultWithValue<Boolean>> {

	private SubscriptionTypeModelRepository repository;

	public CreateSubscriptionTypeHandler(SubscriptionTypeModelRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public ResultWithValue<Boolean> handle(CreateSubscriptionTypeCommand command) {
		SubscriptionTypeModel model = SubscriptionTypeModel.builder()
			.id(command.id())
			.name(command.name())
			.days(command.days())
			.status("HABILITADO")
			.build();
		repository.save(model);
		return ResultWithValue.success(Boolean.TRUE);
	}
}
