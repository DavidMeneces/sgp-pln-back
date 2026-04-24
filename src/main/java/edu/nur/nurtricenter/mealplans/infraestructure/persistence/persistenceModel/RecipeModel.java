package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "recipe")
public class RecipeModel {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "instructions")
	private String instructions;

	@Column(name = "total_calories", columnDefinition = "numeric")
	private BigDecimal totalCalories;

	// Columnas de control de estado entidad
	@Column(name = "transaction")
	private String transaction;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at", columnDefinition = "timestamp")
	private LocalDateTime createdAt;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_at", columnDefinition = "timestamp")
	private LocalDateTime updatedAt;

	public static RecipeModel buildModel(Recipe entity) {
		return RecipeModel.builder()
			.id(entity.getId())
			.name(entity.getName())
			.description(entity.getDescription())
			.instructions(entity.getInstructions())
			.totalCalories(entity.getTotalCalories())
			.transaction(entity.getTransaction())
			.status(entity.getStatus())
			.createdBy(entity.getCreateBy())
			.createdAt(entity.getCreateAt())
			.build();
	}
}
