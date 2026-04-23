package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.IngredientModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IngredientModelRepository extends CrudRepository<IngredientModel, UUID> {

	@Query(value = """
		SELECT i.*
		FROM public.ingredient i
		LIMIT :limit
		OFFSET :offset""", nativeQuery = true)
	List<IngredientModel> findAll(@Param("limit") Integer limit,
								@Param("offset") Integer offset);
}
