package edu.nur.nurtricenter.mealplans.domain.recipe;

import edu.nur.nurtricenter.mealplans.core.abstractions.AggregateRoot;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Recipe extends AggregateRoot {
    private String name;
    private String description;
    private String instructions;
    private BigDecimal totalCalories;
    private List<RecipeIngredient> ingredients;

    public Recipe() {
        super(UUID.randomUUID());
    }

    public Recipe(UUID id, String name, String description, String instructions, BigDecimal totalCalories, List<RecipeIngredient> ingredients) {
        super(id);
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
    }

    public static Recipe create(UUID id, String name, String description, String instructions, BigDecimal totalCalories, List<RecipeIngredient> ingredients) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        if (totalCalories == null || totalCalories.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("totalCalories cannot be null or minor than or equal zero");
        }
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("ingredients cannot be null or empty");
        }
        return new Recipe(id, name, description, instructions, totalCalories, ingredients);
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
}
