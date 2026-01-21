package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.mealplan.mapper.MealPlanDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.IMealPlanRepository;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

@Component
public class GetMealPlanHandler implements Command.Handler<GetMealPlanCommand, ResultWithValue<MealPlanDto>> {

    private IMealPlanRepository repository;

    public GetMealPlanHandler(IMealPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResultWithValue<MealPlanDto> handle(GetMealPlanCommand command) {
        if (!repository.existById(command.id())) {
            return ResultWithValue.validationFailure(Error.notFound("NotFound", "Not found meal plan", command.id().toString()));
        }
        MealPlan mealPlan = repository.getById(command.id(), true);
        return ResultWithValue.success(MealPlanDtoMapper.mapper(mealPlan));
    }

}
