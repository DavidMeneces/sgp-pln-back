package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.mealplan.MealPlan;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel.TransaccionEstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(schema = "public", name = "meal_plan")
public class MealPlanModel {
	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_nutricionist")
	private UUID idNutricionist;

	@Column(name = "id_patient")
	private UUID idPatient;

	@Column(name = "id_subscription")
	private UUID idSubscription;

	@Column(name = "id_appointment")
	private UUID idAppointment;

	@Column(name = "total_calories", columnDefinition = "numeric")
	private BigDecimal totalCalories;

	@Column(name = "total_days")
	private Integer totalDays;

	@Column(name = "star_date", columnDefinition = "timestamp")
	private LocalDate starDate;

	@Column(name = "end_date", columnDefinition = "timestamp")
	private LocalDate endDate;

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

	public static MealPlanModel buildModel(MealPlan entity) {
		var transaction = TransaccionEstadoModel.CREAR;
		return MealPlanModel.builder()
			.id(entity.getId())
			.idNutricionist(entity.getIdNutricionist())
			.idPatient(entity.getIdPatient())
			.idAppointment(entity.getIdAppointment())
			.idSubscription(entity.getIdSubscription())
			.totalCalories(entity.getTotalCalories())
			.starDate(entity.getStarDate())
			.endDate(entity.getEndDate())
			.totalDays(entity.getTotalDays())
			.transaction(transaction.name())
			.status(transaction.getEstado())
			.createdBy("sgp-pln")
			.createdAt(LocalDateTime.now())
			.build();
	}
}
