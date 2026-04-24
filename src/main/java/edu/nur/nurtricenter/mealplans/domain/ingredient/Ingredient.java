package edu.nur.nurtricenter.mealplans.domain.ingredient;

import edu.nur.nurtricenter.mealplans.core.abstractions.AggregateRoot;
import edu.nur.nurtricenter.mealplans.domain.shared.TransactionAggregateEnum;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ingredient extends AggregateRoot {
	private String name;
	private String description;
	private UnitMeasureEnum unitMeasure;
	private BigDecimal caloriesPerGram;

	public Ingredient() {
		super(UUID.randomUUID());
	}

	public Ingredient(
		UUID id,
		String nombre,
		String descripcion,
		UnitMeasureEnum unitMeasure,
		BigDecimal caloriesPerGram,
		String transaction,
		String status,
		String createBy,
		LocalDateTime createAt) {
		super(id);
		this.name = nombre;
		this.description = descripcion;
		this.unitMeasure = unitMeasure;
		this.caloriesPerGram = caloriesPerGram;
		this.transaction = transaction;
		this.status = status;
		this.createBy = createBy;
		this.createAt = createAt;
	}

	public static Ingredient create(
		UUID id,
		String name,
		String description,
		UnitMeasureEnum unitMeasure,
		BigDecimal caloriesPerGram) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be null or empty");
		}
		if (unitMeasure == null) {
			throw new IllegalArgumentException("unitMeasure cannot be null or menor than zero");
		}
		if (caloriesPerGram == null || caloriesPerGram.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("caloriesPerGram cannot be null or menor than zero");
		}
		var transaction = TransactionAggregateEnum.CREAR;
		var status = transaction.getStatus();
		var createBy = "sgp-pln";
		var createAt = LocalDateTime.now();
		return new Ingredient(id, name, description, unitMeasure, caloriesPerGram, transaction.name(), status, createBy, createAt);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public UnitMeasureEnum getUnitMeasure() {
		return unitMeasure;
	}

	public BigDecimal getCaloriesPerGram() {
		return caloriesPerGram;
	}
}
