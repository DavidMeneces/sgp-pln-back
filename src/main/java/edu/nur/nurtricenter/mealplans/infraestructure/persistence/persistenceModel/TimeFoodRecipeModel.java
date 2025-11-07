package edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel;

import edu.nur.nurtricenter.mealplans.domain.mealplan.TimeFoodRecipe;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel.TransaccionEstadoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public static TimeFoodRecipeModel buildModel(UUID idTiempoComida, TimeFoodRecipe entity) {
        var transaccion = TransaccionEstadoModel.CREAR;
        return TimeFoodRecipeModel.builder()
                .id(entity.getId())
                .idTimeFood(idTiempoComida)
                .idRecipe(entity.getIdReceta())
                .portion(entity.getPortion())
                .transaccion(transaccion.name())
                .estado(transaccion.getEstado())
                .usuarioCreacion("sgp-pln")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

}
