package io.github.ndimovt.repository;

import io.github.ndimovt.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface PlayerRepository
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
