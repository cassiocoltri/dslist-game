package com.devsuperior.dslist_game.repositories;

import com.devsuperior.dslist_game.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
