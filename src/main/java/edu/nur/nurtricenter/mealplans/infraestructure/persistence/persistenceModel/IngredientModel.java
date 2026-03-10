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

	public static IngredientModel buildModel(Ingredient entity) {
		var transaccion = TransaccionEstadoModel.CREAR;
		return IngredientModel.builder()
				.id(entity.getId())
				.name(entity.getName())
				.description(entity.getDescription())
				.unitMeasure(entity.getUnitMeasure().name())
				.caloriesPerGram(entity.getCaloriesPerGram())
				.transaccion(transaccion.name())
				.estado(transaccion.getEstado())
				.usuarioCreacion("sgp-pln")
				.fechaCreacion(LocalDateTime.now())
				.build();
	}
}
