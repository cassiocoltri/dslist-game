package com.devsuperior.dslist_game.repositories;

import com.devsuperior.dslist_game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
