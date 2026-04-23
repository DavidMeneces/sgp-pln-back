package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.List;

public record GetMealPlansCommand(Integer page, Integer size) implements Command<ResultWithValue<List<MealPlanDto>>> {}
