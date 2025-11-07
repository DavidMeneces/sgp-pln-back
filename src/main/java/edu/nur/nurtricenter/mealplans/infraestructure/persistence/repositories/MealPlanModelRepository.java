package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MealPlanModelRepository extends CrudRepository<MealPlanModel, UUID> {
}
