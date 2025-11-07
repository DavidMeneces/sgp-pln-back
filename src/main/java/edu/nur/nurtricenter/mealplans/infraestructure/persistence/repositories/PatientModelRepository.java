package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PatientModelRepository extends CrudRepository<PatientModel, UUID> {
}
