package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.ingredient.mapper.IngredientDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.ingredient.IIngredientRepository;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class GetIngredientByIdHandler
		implements Command.Handler<GetIngredientByIdCommand, ResultWithValue<IngredientDto>> {

	private final IIngredientRepository repository;

	public GetIngredientByIdHandler(IIngredientRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResultWithValue<IngredientDto> handle(GetIngredientByIdCommand command) {
		if (!repository.existById(command.id())) {
			return ResultWithValue.validationFailure(
					Error.notFound("NotFound", "Not found ingredient", command.id().toString()));
		}
		Ingredient ingredient = repository.getById(command.id(), true);
		return ResultWithValue.success(IngredientDtoMapper.mapper(ingredient));
	}
}
