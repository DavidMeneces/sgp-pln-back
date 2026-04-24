package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.NutricionistModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NutricionistModelRepository extends CrudRepository<NutricionistModel, UUID> {

	@Query(value = """
		SELECT a.*
		FROM public.nutricionist a
		LIMIT :limit
		OFFSET :offset""", nativeQuery = true)
	List<NutricionistModel> findAll(@Param("limit") Integer limit,
								@Param("offset") Integer offset);
}
