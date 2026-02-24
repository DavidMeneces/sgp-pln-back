package edu.nur.nurtricenter.mealplans.infraestructure.outbox;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OutboxEventRepository extends CrudRepository<OutboxEventEntity, UUID> {
  List<OutboxEventEntity> findByProcessedOnIsNullAndNextAttemptAtLessThanEqualOrderByOccurredOnAsc(LocalDateTime now, Pageable pageable);
}
