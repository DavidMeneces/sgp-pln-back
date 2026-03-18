package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFoodRecipe;
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
@Table(schema = "public", name = "time_food_recipe")
public class TimeFoodRecipeModel {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_time_food")
	private UUID idTimeFood;

	@Column(name = "id_recipe")
	private UUID idRecipe;

	@Column(name = "portion", columnDefinition = "numeric")
	private Integer portion;

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

	public static TimeFoodRecipeModel buildModel(UUID idTiempoComida, TimeFoodRecipe entity) {
		var transaccion = TransaccionEstadoModel.CREAR;
		return TimeFoodRecipeModel.builder()
				.id(entity.getId())
				.idTimeFood(idTiempoComida)
				.idRecipe(entity.getIdRecipe())
				.portion(entity.getPortion())
				.transaction(transaccion.name())
				.status(transaccion.getEstado())
				.createdBy("sgp-pln")
				.createdAt(LocalDateTime.now())
				.build();
	}
}
