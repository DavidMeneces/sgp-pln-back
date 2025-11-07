package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanDayModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MealPlanDayModelRepository extends CrudRepository<MealPlanDayModel, UUID> {
}
