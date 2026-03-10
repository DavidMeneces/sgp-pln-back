package edu.nur.nurtricenter.mealplans.domain.recipe.event;

import edu.nur.nurtricenter.mealplans.core.abstractions.DomainEvent;
import edu.nur.nurtricenter.mealplans.domain.recipe.RecipeIngredient;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class RecipeCreatedEvent extends DomainEvent {

	private UUID id;
	private String name;
	private String description;
	private String instructions;
	private BigDecimal totalCalories;
	private List<RecipeIngredient> ingredients;

	public RecipeCreatedEvent(
			UUID id,
			String name,
			String description,
			String instructions,
			BigDecimal totalCalories,
			List<RecipeIngredient> ingredients) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.instructions = instructions;
		this.totalCalories = totalCalories;
		this.ingredients = ingredients;
	}

	@Override
	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getInstructions() {
		return instructions;
	}

	public BigDecimal getTotalCalories() {
		return totalCalories;
	}

	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	@Override
	public String getAggregateType() {
		return "Recipe";
	}

	@Override
	public String getAggregateId() {
		return id.toString();
	}

	@Override
	public String getEventName() {
		return "planes.receta.creado";
	}

	@Override
	public Object getPayload() {
		return new Payload(
				id.toString(), name, description, instructions, totalCalories, ingredients);
	}

	private record Payload(
			String id,
			String name,
			String description,
			String instructions,
			BigDecimal totalCalories,
			List<RecipeIngredient> ingredients) {}
}
