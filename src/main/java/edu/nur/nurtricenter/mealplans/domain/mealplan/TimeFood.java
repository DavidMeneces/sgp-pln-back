package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.core.abstractions.Entity;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import java.util.List;
import java.util.UUID;

public class TimeFood extends Entity {
	private TimeFoodEnum type;
	private Integer order;
	private List<TimeFoodRecipe> recipes;

	public TimeFood() {
		super();
	}

	public TimeFood(UUID id, TimeFoodEnum type, Integer order, List<TimeFoodRecipe> recipes) {
		super(id);
		this.type = type;
		this.order = order;
		this.recipes = recipes;
	}

	public static TimeFood create(
			UUID id, TimeFoodEnum type, Integer order, List<TimeFoodRecipe> recipes) {
		if (id == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (type == null) {
			throw new IllegalArgumentException("type cannot be null");
		}
		if (order == null || order <= 0) {
			throw new IllegalArgumentException("order cannot be null or minor equal zero");
		}
		if (recipes == null || recipes.isEmpty()) {
			throw new IllegalArgumentException("recipes cannot be null or empty");
		}
		return new TimeFood(id, type, order, recipes);
	}

	public TimeFoodEnum getType() {
		return type;
	}

	public Integer getOrder() {
		return order;
	}

	public List<TimeFoodRecipe> getRecipes() {
		return recipes;
	}
}
