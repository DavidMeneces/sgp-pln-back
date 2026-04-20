package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanDayModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MealPlanDayModelRepository extends CrudRepository<MealPlanDayModel, UUID> {

	@Query("""
		SELECT mpd
		FROM MealPlanDayModel mpd
		WHERE mpd.idMealPlan = :idMealPlan""")
	List<MealPlanDayModel> findAllByIdMealPlan(@Param("idMealPlan") UUID idMealPlan);

	@Query(
			value =
					"""
		WITH meal_plan_to_delete AS (
		SELECT mpd.id
		FROM public.meal_plan_day mpd
		WHERE mpd.id_meal_plan = :idMealPlan
		), time_food_to_delete AS (
		SELECT tf.id
		FROM public.time_food tf
		WHERE EXISTS (SELECT 1 FROM meal_plan_to_delete mptd WHERE mptd.id = tf.id_meal_plan_day)
		), time_food_recipe_deleted AS (
		DELETE FROM public.time_food_recipe tfr
		WHERE EXISTS (SELECT 1 FROM time_food_to_delete tftd WHERE tftd.id = tfr.id_time_food)
		), time_food_deleted AS (
		DELETE FROM public.time_food tf
		WHERE EXISTS (SELECT 1 FROM time_food_to_delete tftd WHERE tftd.id = tf.id)
		), meal_plan_day_deleted  as (
		DELETE FROM public.meal_plan_day mpd
		WHERE EXISTS (SELECT 1 FROM meal_plan_to_delete mptd WHERE mptd.id = mpd.id)
		RETURNING id
		) SELECT COUNT(id) FROM meal_plan_day_deleted;""",
			nativeQuery = true)
	Integer deleteAllByIdMealPlan(@Param("idMealPlan") UUID idMealPlan);
}
