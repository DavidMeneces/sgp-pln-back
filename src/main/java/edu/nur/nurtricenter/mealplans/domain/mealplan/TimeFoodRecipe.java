package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.core.abstractions.Entity;

import java.util.UUID;

public class TimeFoodRecipe extends Entity {
    private UUID idReceta;
    private Integer portion;

    public TimeFoodRecipe() {
        super();
    }

    private TimeFoodRecipe(UUID id, UUID idReceta, Integer portion) {
        super(id);
        this.idReceta = idReceta;
        this.portion = portion;
    }

    public static TimeFoodRecipe create(UUID id, UUID idRecipe, Integer portion) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (idRecipe == null) {
            throw new IllegalArgumentException("idRecipe cannot be null");
        }
        if (portion == null || portion <= 0) {
            throw new IllegalArgumentException("portion cannot be null or minor equal zero");
        }
        return new TimeFoodRecipe(id, idRecipe, portion);
    }

    public UUID getIdReceta() {
        return idReceta;
    }

    public Integer getPortion() {
        return portion;
    }
}
