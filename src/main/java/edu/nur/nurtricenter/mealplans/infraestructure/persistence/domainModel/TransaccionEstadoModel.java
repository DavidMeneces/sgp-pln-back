package edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel;

import lombok.Getter;

@Getter
public enum TransaccionEstadoModel {

    CREAR("CREADO"), ELIMINAR("ELIMINADO");
    private final String estado;

    TransaccionEstadoModel(String estado) {
        this.estado = estado;
    }
}
