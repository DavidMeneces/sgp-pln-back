package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodRecipeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TimeFoodRecipeModelRepository extends CrudRepository<TimeFoodRecipeModel, UUID> {

}