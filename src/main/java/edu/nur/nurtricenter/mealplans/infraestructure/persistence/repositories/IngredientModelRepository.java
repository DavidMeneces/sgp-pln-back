package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.IngredientModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IngredientModelRepository extends CrudRepository<IngredientModel, UUID> {

}
