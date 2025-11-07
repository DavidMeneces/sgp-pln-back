package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RecipeModelRepository extends CrudRepository<RecipeModel, UUID> {

}
