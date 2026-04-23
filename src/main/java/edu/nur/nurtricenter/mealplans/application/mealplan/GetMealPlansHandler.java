package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.mealplan.mapper.MealPlanDtoMapper;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.IMealPlanRepository;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMealPlansHandler implements Command.Handler<GetMealPlansCommand, ResultWithValue<List<MealPlanDto>>> {

	private IMealPlanRepository repository;

	public GetMealPlansHandler(IMealPlanRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResultWithValue<List<MealPlanDto>> handle(GetMealPlansCommand command) {
		List<MealPlan> mealPlans = repository.get(command.page(), command.size());
		return ResultWithValue.success(mealPlans.stream().map(MealPlanDtoMapper::mapper).toList());
	}
}
