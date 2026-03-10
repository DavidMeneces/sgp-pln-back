package edu.nur.nurtricenter.mealplans.domain.recipe;

import edu.nur.nurtricenter.mealplans.core.abstractions.IRepository;
import java.util.UUID;

public interface IRecipeRepository extends IRepository<Recipe> {

	boolean existById(UUID id);

	boolean existById(UUID id, String status);
}
