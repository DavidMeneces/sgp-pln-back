package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.IMealPlanRepository;
import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import edu.nur.nurtricenter.mealplans.domain.mealplan.event.MealPlanCancelledEvent;
import edu.nur.nurtricenter.mealplans.domain.mealplan.event.MealPlanCompletedEvent;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompleteMealPlanHandler implements Command.Handler<CompleteMealPlanCommand, ResultWithValue<Boolean>> {

	private final IMealPlanRepository repository;
	private final UnitOfWork unitOfWork;

	public CompleteMealPlanHandler(IMealPlanRepository repository, UnitOfWork unitOfWork) {
		this.repository = repository;
		this.unitOfWork = unitOfWork;
	}

	@Override
	public ResultWithValue<Boolean> handle(CompleteMealPlanCommand command) {
		if (!repository.existById(command.id(), "CREADO")) {
			return ResultWithValue.validationFailure(Error.notFound("NotFound", "Not found meal plan", command.id().toString()));
		}
		MealPlan mealPlan = repository.getById(command.id(), true);
		this.repository.completeById(command.id());
		mealPlan.addDomainEvent(new MealPlanCompletedEvent(command.id(), LocalDateTime.now()));
		this.unitOfWork.commitAsync(mealPlan);
		return ResultWithValue.success(Boolean.TRUE);
	}
}
