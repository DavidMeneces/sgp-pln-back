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

	public static RecipeIngredientModel buildModel(UUID idReceta, RecipeIngredient entity) {
		var transaccion = TransaccionEstadoModel.CREAR;
		return RecipeIngredientModel.builder()
				.id(entity.getId())
				.idRecipe(idReceta)
				.idIngredient(entity.getIdIngredient())
				.quantity(entity.getQuantity())
				.transaccion(transaccion.name())
				.estado(transaccion.getEstado())
				.usuarioCreacion("sgp-pln")
				.fechaCreacion(LocalDateTime.now())
				.build();
	}
}
