package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel.TransaccionEstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "recipe")
public class RecipeModel {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "instructions")
    private String instructions;
    @Column(name = "total_calories", columnDefinition = "numeric")
    private BigDecimal totalCalories;
    //Columnas de control de estado entidad
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

    public static RecipeModel buildModel(Recipe entity) {
        var transaccion = TransaccionEstadoModel.CREAR;
        return RecipeModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .instructions(entity.getInstructions())
                .totalCalories(entity.getTotalCalories())
                .transaccion(transaccion.name())
                .estado(transaccion.getEstado())
                .usuarioCreacion("sgp-pln")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}
