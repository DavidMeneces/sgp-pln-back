package edu.nur.nurtricenter.mealplans.domain.shared;


public enum TransactionAggregateEnum {

	CREAR("CREADO"),
	CANCELAR("CANCELADO"),
	COMPLETAR("COMPLETADO"),
	ELIMINAR("ELIMINADO");
	private final String status;

	TransactionAggregateEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
