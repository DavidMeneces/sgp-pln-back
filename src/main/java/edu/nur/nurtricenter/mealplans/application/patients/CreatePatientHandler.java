package edu.nur.nurtricenter.mealplans.application.patients;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.recipe.CreateRecipeCommand;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePatientHandler implements Command.Handler<CreatePatientCommand, ResultWithValue<Boolean>> {

    private IRecipeRepository repository;
    private final UnitOfWork unitOfWork;

    public CreatePatientHandler(IRecipeRepository repository, UnitOfWork unitOfWork) {
        this.repository = repository;
        this.unitOfWork = unitOfWork;
    }

    @Override
    public ResultWithValue<Boolean> handle(CreatePatientCommand command) {
        return ResultWithValue.success(Boolean.TRUE);
    }
}