package com.devsuperior.dslist_game.repositories;

import com.devsuperior.dslist_game.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying // Update, save e modificação tem que colocar essa anotação!
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition " +
            "WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
