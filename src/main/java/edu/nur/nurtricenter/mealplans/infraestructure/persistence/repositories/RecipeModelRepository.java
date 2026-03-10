package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RecipeModelRepository extends CrudRepository<RecipeModel, UUID> {}
