package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AppointmentModelRepository extends CrudRepository<AppointmentModel, UUID> {

	@Query(value = """
		SELECT a.*
		FROM public.appointment a
		WHERE a.id_patient = :idPatient
		AND a.status = :status
		LIMIT :limit
		OFFSET :offset""", nativeQuery = true)
	List<AppointmentModel> findAllByPatient(
		@Param("idPatient") UUID idPatient,
		@Param("status") String status,
		@Param("limit") Integer limit,
		@Param("offset") Integer offset);
}
