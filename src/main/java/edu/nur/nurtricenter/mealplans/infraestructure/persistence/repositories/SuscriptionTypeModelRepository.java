package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SuscriptionTypeModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface SuscriptionTypeModelRepository
		extends CrudRepository<SuscriptionTypeModel, UUID> {}
