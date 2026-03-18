package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFood;
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
@Table(schema = "public", name = "time_food")
public class TimeFoodModel {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_meal_plan_day")
	private UUID idMealPlanDay;

	@Column(name = "type")
	private String type;

	@Column(name = "sort_order", columnDefinition = "numeric")
	private Integer order;

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

	public static TimeFoodModel buildModel(UUID idPlanAlimentarioDia, TimeFood entity) {
		var transaccion = TransaccionEstadoModel.CREAR;
		return TimeFoodModel.builder()
				.id(entity.getId())
				.idMealPlanDay(idPlanAlimentarioDia)
				.type(entity.getType().name())
				.order(entity.getOrder())
				.transaction(transaccion.name())
				.status(transaccion.getEstado())
				.createdBy("sgp-pln")
				.createdAt(LocalDateTime.now())
				.build();
	}
}
