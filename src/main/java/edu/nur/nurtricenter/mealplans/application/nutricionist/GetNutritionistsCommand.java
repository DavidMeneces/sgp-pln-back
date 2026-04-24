package edu.nur.nurtricenter.mealplans.application.nutricionist;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.NutricionistModel;

import java.util.List;

public record GetNutritionistsCommand(Integer page, Integer size) implements Command<ResultWithValue<List<NutricionistModel>>> {}
