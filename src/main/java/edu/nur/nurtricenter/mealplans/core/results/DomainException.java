package edu.nur.nurtricenter.mealplans.core.results;

public class DomainException extends RuntimeException {

	private final Error error;

	public DomainException(Error error) {
		super(error != null ? error.toString() : null);
		this.error = error;
	}

	public Error getError() {
		return error;
	}
}
