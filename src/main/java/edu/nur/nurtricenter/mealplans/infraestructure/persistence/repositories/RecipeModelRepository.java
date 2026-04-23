package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecipeModelRepository extends CrudRepository<RecipeModel, UUID> {

	@Query(value = """
		SELECT r.*
		FROM public.recipe r
		LIMIT :limit
		OFFSET :offset""", nativeQuery = true)
	List<RecipeModel> findAll(@Param("limit") Integer limit,
								@Param("offset") Integer offset);
}
