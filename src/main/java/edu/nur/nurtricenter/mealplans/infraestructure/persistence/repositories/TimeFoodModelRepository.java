package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodModel;
import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
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

	@Transactional
	@Modifying
	@Query(value = """
		DELETE FROM time_food tf
		WHERE EXISTS (
		SELECT 1 FROM meal_plan_day mpd
		WHERE mpd.id = tf.id_meal_plan_day
		AND mpd.id_meal_plan = :idMealPlan
		)""", nativeQuery = true)
	void deleteAllByIdMealPlan(@Param("idMealPlan") UUID idMealPlan);
}
