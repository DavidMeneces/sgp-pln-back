package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface PatientModelRepository extends CrudRepository<PatientModel, UUID> {}
