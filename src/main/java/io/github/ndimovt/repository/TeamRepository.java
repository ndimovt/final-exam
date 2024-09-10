package io.github.ndimovt.repository;

import io.github.ndimovt.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface TeamRepository
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
}
