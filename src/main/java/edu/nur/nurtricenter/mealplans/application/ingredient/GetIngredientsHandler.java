package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.ingredient.mapper.IngredientDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.ingredient.IIngredientRepository;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetIngredientsHandler implements Command.Handler<GetIngredientsCommand, ResultWithValue<List<IngredientDto>>> {

	private final IIngredientRepository repository;

	public GetIngredientsHandler(IIngredientRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResultWithValue<List<IngredientDto>> handle(GetIngredientsCommand command) {
		List<Ingredient> ingredients = repository.get(command.page(), command.size());
		return ResultWithValue.success(ingredients.stream().map(IngredientDtoMapper::mapper).toList());
	}
}
