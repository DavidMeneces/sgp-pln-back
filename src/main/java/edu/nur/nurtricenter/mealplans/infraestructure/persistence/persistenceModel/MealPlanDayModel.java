package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlanDay;
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
@Table(schema = "public", name = "meal_plan_day")
public class MealPlanDayModel {
	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_meal_plan")
	private UUID idMealPlan;

	@Column(name = "day_number")
	private Integer day;

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

	public static MealPlanDayModel buildModel(UUID idPlanAlimentario, MealPlanDay entity) {
		var transaction = TransaccionEstadoModel.CREAR;
		return MealPlanDayModel.builder()
				.id(entity.getId())
				.idMealPlan(idPlanAlimentario)
				.day(entity.getDay())
				.transaction(transaction.name())
				.status(transaction.getEstado())
				.createdBy("sgp-pln")
				.createdAt(LocalDateTime.now())
				.build();
	}
}
