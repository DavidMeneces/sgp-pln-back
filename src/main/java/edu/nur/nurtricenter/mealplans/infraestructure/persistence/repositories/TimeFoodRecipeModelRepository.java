package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodRecipeModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TimeFoodRecipeModelRepository extends CrudRepository<TimeFoodRecipeModel, UUID> {

	@Query(
		"""
			SELECT tfr
			FROM TimeFoodRecipeModel tfr
			WHERE tfr.idTimeFood in (:idTimeFoodList)""")
	List<TimeFoodRecipeModel> findAllByIdTimeFood(
		@Param("idTimeFoodList") List<UUID> idTimeFoodList);

	@Transactional
	@Modifying
	@Query(value = """
		DELETE FROM time_food_recipe tfr
		WHERE EXISTS (
		SELECT 1 FROM time_food tf
		WHERE tf.id = tfr.id_time_food
		AND EXISTS (
		SELECT 1 FROM meal_plan_day mpd
		WHERE mpd.id = tf.id_meal_plan_day
		AND mpd.id_meal_plan = :idMealPlan
		))""", nativeQuery = true)
	void deleteAllByIdMealPlan(@Param("idMealPlan") UUID idMealPlan);
}
