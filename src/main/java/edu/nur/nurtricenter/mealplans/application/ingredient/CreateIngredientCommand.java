package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateIngredientCommand(String name, String description, UnitMeasureEnum unitMeasure, BigDecimal caloriesPerGram) implements Command<ResultWithValue<UUID>> {
}
