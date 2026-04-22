package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.recipe.mapper.ReciperDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetRecipesHandler
	implements Command.Handler<GetRecipesCommand, ResultWithValue<List<RecipeDto>>> {

	private IRecipeRepository repository;

	public GetRecipesHandler(IRecipeRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResultWithValue<List<RecipeDto>> handle(GetRecipesCommand command) {
		List<Recipe> recipes = repository.get(command.page(), command.size());
		return ResultWithValue.success(recipes.stream().map(ReciperDtoMapper::mapper).toList());
	}
}
