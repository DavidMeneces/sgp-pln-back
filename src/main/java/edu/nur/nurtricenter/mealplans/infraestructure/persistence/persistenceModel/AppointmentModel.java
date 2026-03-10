package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(schema = "public", name = "appointment")
public class AppointmentModel {
	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "id_patient")
	private UUID idPatient;

	@Column(name = "status")
	private String status;
}
