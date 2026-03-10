package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MealPlanModelRepository extends CrudRepository<MealPlanModel, UUID> {

	@Query(
			value =
					"""
			SELECT EXISTS (
				SELECT 1
				FROM meal_plan mp
				WHERE mp.id = :id
				AND mp.estado = :status)""",
			nativeQuery = true)
	Boolean existById(@Param("id") UUID id, @Param("status") String status);
}
