package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SuscriptionTypeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SuscriptionTypeModelRepository extends CrudRepository<SuscriptionTypeModel, UUID> {
}
