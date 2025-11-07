package edu.nur.nurtricenter.mealplans.core.results;

public class ResultWithValue<T> extends Result {

    private final T value;

    public ResultWithValue(T value, boolean isSuccess, Error error) {
        super(isSuccess, error);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static <T> ResultWithValue<T> of(T value) {
        if (value != null) {
            return success(value);
        } else {
            return failure(Error.NULL_VALUE);
        }
    }

    public static <T> ResultWithValue<T> validationFailure(Error error) {
        return new ResultWithValue<>(null, false, error);
    }
}

