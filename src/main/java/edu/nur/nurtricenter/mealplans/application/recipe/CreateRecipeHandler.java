package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.domain.recipe.RecipeIngredient;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CreateRecipeHandler implements Command.Handler<CreateRecipeCommand, ResultWithValue<UUID>> {

    private IRecipeRepository repository;
    private final UnitOfWork unitOfWork;

    public CreateRecipeHandler(IRecipeRepository repository, UnitOfWork unitOfWork) {
        this.repository = repository;
        this.unitOfWork = unitOfWork;
    }

    @Override
    public ResultWithValue<UUID> handle(CreateRecipeCommand command) {
        List<RecipeIngredient> ingredients = buildIngredients(command.ingredients());
        var recipe = Recipe.create(UUID.randomUUID(),
                command.name(), command.description(), command.instructions(), command.totalCalories(), ingredients);
        repository.add(recipe);
        this.unitOfWork.commitAsync();
        return ResultWithValue.success(recipe.getId());
    }

    private List<RecipeIngredient> buildIngredients(List<CreateRecipeCommand.RecipeIngredientCommand> requestList) {
        return (requestList != null) ? requestList.stream()
                .map(request -> RecipeIngredient.crear(UUID.randomUUID(), request.idIngredient(), request.quantity()))
                .toList() : new ArrayList<>();
    }

}
