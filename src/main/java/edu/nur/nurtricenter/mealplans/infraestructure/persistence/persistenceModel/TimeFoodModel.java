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
	@Column(name = "transaccion")
	private String transaccion;

	@Column(name = "estado")
	private String estado;

	@Column(name = "usuario_creacion")
	private String usuarioCreacion;

	@Column(name = "fecha_creacion", columnDefinition = "timestamp")
	private LocalDateTime fechaCreacion;

	@Column(name = "usuario_modificacion")
	private String usuarioModificacion;

	@Column(name = "fecha_modificacion", columnDefinition = "timestamp")
	private LocalDateTime fechaModificacion;

	public static TimeFoodModel buildModel(UUID idPlanAlimentarioDia, TimeFood entity) {
		var transaccion = TransaccionEstadoModel.CREAR;
		return TimeFoodModel.builder()
				.id(entity.getId())
				.idMealPlanDay(idPlanAlimentarioDia)
				.type(entity.getType().name())
				.order(entity.getOrder())
				.transaccion(transaccion.name())
				.estado(transaccion.getEstado())
				.usuarioCreacion("sgp-pln")
				.fechaCreacion(LocalDateTime.now())
				.build();
	}
}
