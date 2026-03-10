package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.AppointmentModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentModelRepository extends CrudRepository<AppointmentModel, UUID> {}
