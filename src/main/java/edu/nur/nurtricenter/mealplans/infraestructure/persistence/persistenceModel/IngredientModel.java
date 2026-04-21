package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel.TransaccionEstadoModel;
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
@Table(schema = "public", name = "ingredient")
public class IngredientModel {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "unit_measure")
	private String unitMeasure;

	@Column(name = "calories_per_gram")
	private BigDecimal caloriesPerGram;

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

	public static IngredientModel buildModel(Ingredient entity) {
		var transaction = TransaccionEstadoModel.CREAR;
		return IngredientModel.builder()
				.id(entity.getId())
				.name(entity.getName())
				.description(entity.getDescription())
				.unitMeasure(entity.getUnitMeasure().name())
				.caloriesPerGram(entity.getCaloriesPerGram())
				.transaction(transaction.name())
				.status(transaction.getEstado())
				.createdBy("sgp-pln")
				.createdAt(LocalDateTime.now())
				.build();
	}
}
