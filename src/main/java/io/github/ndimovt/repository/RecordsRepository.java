package io.github.ndimovt.repository;

import io.github.ndimovt.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface RecordsRepository
 */
@Repository
public interface RecordsRepository extends JpaRepository<Record, Long> {
}
