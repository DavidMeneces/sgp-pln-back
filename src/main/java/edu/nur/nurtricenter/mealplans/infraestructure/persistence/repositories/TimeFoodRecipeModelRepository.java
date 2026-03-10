package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodRecipeModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TimeFoodRecipeModelRepository extends CrudRepository<TimeFoodRecipeModel, UUID> {

	@Query(
			"""
			SELECT tfr
			FROM TimeFoodRecipeModel tfr
			WHERE tfr.idTimeFood in (:idTimeFoodList)""")
	List<TimeFoodRecipeModel> findAllByIdTimeFood(
			@Param("idTimeFoodList") List<UUID> idTimeFoodList);
}
