package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.ingredient.IIngredientRepository;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CreateIngredientHandler
		implements Command.Handler<CreateIngredientCommand, ResultWithValue<UUID>> {

	private final IIngredientRepository repository;
	private final UnitOfWork unitOfWork;

	public CreateIngredientHandler(IIngredientRepository repository, UnitOfWork unitOfWork) {
		this.repository = repository;
		this.unitOfWork = unitOfWork;
	}

	@Override
	public ResultWithValue<UUID> handle(CreateIngredientCommand command) {
		var ingrediente =
				Ingredient.create(
						UUID.randomUUID(),
						command.name(),
						command.description(),
						command.unitMeasure(),
						command.caloriesPerGram());
		repository.add(ingrediente);
		this.unitOfWork.commitAsync();
		return ResultWithValue.success(ingrediente.getId());
	}
}
