package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.mealplan.mapper.MealPlanDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.IMealPlanRepository;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import org.springframework.stereotype.Component;

@Component
public class GetMealPlanByIdHandler
	implements Command.Handler<GetMealPlanByIdCommand, ResultWithValue<MealPlanDto>> {

	private IMealPlanRepository repository;

	public GetMealPlanByIdHandler(IMealPlanRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResultWithValue<MealPlanDto> handle(GetMealPlanByIdCommand command) {
		if (!repository.existById(command.id())) {
			return ResultWithValue.validationFailure(
				Error.notFound("NotFound", "Not found meal plan", command.id().toString()));
		}
		MealPlan mealPlan = repository.getById(command.id(), true);
		return ResultWithValue.success(MealPlanDtoMapper.mapper(mealPlan));
	}
}
