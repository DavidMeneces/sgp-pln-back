package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.*;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

@Component
public class UpdateMealPlanHandler implements Command.Handler<UpdateMealPlanCommand, ResultWithValue<Boolean>> {

    private final IMealPlanRepository repository;
    private final UnitOfWork unitOfWork;

    public UpdateMealPlanHandler(IMealPlanRepository repository, UnitOfWork unitOfWork) {
        this.repository = repository;
        this.unitOfWork = unitOfWork;
    }

    @Override
    public ResultWithValue<Boolean> handle(UpdateMealPlanCommand request) {
        return null;
    }
}
