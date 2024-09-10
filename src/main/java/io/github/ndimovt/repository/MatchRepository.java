package io.github.ndimovt.repository;

import io.github.ndimovt.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface MatchRepository
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
