package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SubscriptionTypeModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubscriptionTypeModelRepository
		extends CrudRepository<SubscriptionTypeModel, UUID> {

	@Query(value = """
		SELECT st.*
		FROM public.subscription_type st
		LIMIT :limit
		OFFSET :offset""", nativeQuery = true)
	List<SubscriptionTypeModel> findAll(@Param("limit") Integer limit,
								@Param("offset") Integer offset);
}
