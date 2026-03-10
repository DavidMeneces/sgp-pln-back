package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.IngredientModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface IngredientModelRepository extends CrudRepository<IngredientModel, UUID> {}
