package edu.nur.nurtricenter.mealplans.application.subscription;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SubscriptionTypeModel;

import java.util.List;

public record GetSubscriptionTypesCommand(Integer page, Integer size) implements Command<ResultWithValue<List<SubscriptionTypeModel>>> {}
