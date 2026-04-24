package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PatientModelRepository extends CrudRepository<PatientModel, UUID> {
	@Query(value = """
		SELECT a.*
		FROM public.patient a
		LIMIT :limit
		OFFSET :offset""", nativeQuery = true)
	List<PatientModel> findAll(@Param("limit") Integer limit,
									@Param("offset") Integer offset);
}
