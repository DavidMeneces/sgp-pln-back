package edu.nur.nurtricenter.mealplans.domain.recipe;

import edu.nur.nurtricenter.mealplans.core.abstractions.Entity;
import java.util.UUID;

public class RecipeIngredient extends Entity {
	private UUID idIngredient;
	private Integer quantity;

	public RecipeIngredient() {
		super();
	}

	public RecipeIngredient(UUID id, UUID idIngrediente, Integer quantity) {
		super(id);
		this.idIngredient = idIngrediente;
		this.quantity = quantity;
	}

	public static RecipeIngredient crear(UUID id, UUID idIngredient, Integer quantity) {
		if (id == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (idIngredient == null) {
			throw new IllegalArgumentException("idIngredient cannot be null");
		}
		if (quantity == null || quantity <= 0) {
			throw new IllegalArgumentException("quantity cannot be null and minor than zero");
		}
		return new RecipeIngredient(id, idIngredient, quantity);
	}

	public UUID getIdIngredient() {
		return idIngredient;
	}

	public Integer getQuantity() {
		return quantity;
	}
}
