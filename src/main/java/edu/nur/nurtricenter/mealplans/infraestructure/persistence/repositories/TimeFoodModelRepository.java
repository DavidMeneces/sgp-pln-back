package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TimeFoodModelRepository extends CrudRepository<TimeFoodModel, UUID> {

	@Query(
			"""
			SELECT tf
			FROM TimeFoodModel tf
			WHERE tf.idMealPlanDay in (:idMealPlanDayList)""")
	List<TimeFoodModel> findAllByIdMealPlanDay(
			@Param("idMealPlanDayList") List<UUID> idMealPlanDayList);
}
