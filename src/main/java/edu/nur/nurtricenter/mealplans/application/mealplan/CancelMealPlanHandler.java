package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.*;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

@Component
public class CancelMealPlanHandler implements Command.Handler<CancelMealPlanCommand, ResultWithValue<Boolean>> {

    private final IMealPlanRepository repository;
    private final UnitOfWork unitOfWork;

    public CancelMealPlanHandler(IMealPlanRepository repository, UnitOfWork unitOfWork) {
        this.repository = repository;
        this.unitOfWork = unitOfWork;
    }

    @Override
    public ResultWithValue<Boolean> handle(CancelMealPlanCommand command) {
        return null;
    }
}
