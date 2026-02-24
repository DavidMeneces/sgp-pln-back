package edu.nur.nurtricenter.mealplans.infraestructure.inbound;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface InboundEventRepository extends JpaRepository<InboundEventEntity, UUID> {
  Optional<InboundEventEntity> findByEventId(UUID eventId);
}
