package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

@Component
public class GetMealPlanHandler implements Command.Handler<GetMealPlanCommand, ResultWithValue<MealPlanDto>> {

    private IRecipeRepository repository;
    private final UnitOfWork unitOfWork;

    public GetMealPlanHandler(IRecipeRepository repository, UnitOfWork unitOfWork) {
        this.repository = repository;
        this.unitOfWork = unitOfWork;
    }

    @Override
    public ResultWithValue<MealPlanDto> handle(GetMealPlanCommand command) {
        if (!repository.existById(command.id())) {
            return ResultWithValue.validationFailure(Error.notFound("NotFound", "Not found recipe", command.id().toString()));
        }
        Recipe recipe = repository.getById(command.id(), true);
        return ResultWithValue.success(new MealPlanDto());
    }

}
