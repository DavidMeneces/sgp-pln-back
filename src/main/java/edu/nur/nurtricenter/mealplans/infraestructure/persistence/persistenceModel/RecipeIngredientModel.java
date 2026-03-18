package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.recipe.RecipeIngredient;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel.TransaccionEstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(schema = "public", name = "recipe_ingredient")
public class RecipeIngredientModel {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_recipe")
	private UUID idRecipe;

	@Column(name = "id_ingredient")
	private UUID idIngredient;

	@Column(name = "quantity", columnDefinition = "numeric")
	private Integer quantity;

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

	public static RecipeIngredientModel buildModel(UUID idReceta, RecipeIngredient entity) {
		var transaccion = TransaccionEstadoModel.CREAR;
		return RecipeIngredientModel.builder()
				.id(entity.getId())
				.idRecipe(idReceta)
				.idIngredient(entity.getIdIngredient())
				.quantity(entity.getQuantity())
				.transaction(transaccion.name())
				.status(transaccion.getEstado())
				.createdBy("sgp-pln")
				.createdAt(LocalDateTime.now())
				.build();
	}
}
