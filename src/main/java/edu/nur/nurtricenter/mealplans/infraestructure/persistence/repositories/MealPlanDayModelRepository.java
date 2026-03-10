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
	List<MealPlanDayModel> findAllByIdMealPlan(@Param("idMealPlan") UUID id);
}
