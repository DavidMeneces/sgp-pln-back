package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.recipe.mapper.ReciperDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import org.springframework.stereotype.Component;

@Component
public class GetRecipeHandler
		implements Command.Handler<GetRecipeCommand, ResultWithValue<RecipeDto>> {

	private IRecipeRepository repository;

	public GetRecipeHandler(IRecipeRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResultWithValue<RecipeDto> handle(GetRecipeCommand command) {
		if (!repository.existById(command.id())) {
			return ResultWithValue.validationFailure(
					Error.notFound("NotFound", "Not found recipe", command.id().toString()));
		}
		Recipe recipe = repository.getById(command.id(), true);
		return ResultWithValue.success(ReciperDtoMapper.mapper(recipe));
	}
}
