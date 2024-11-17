package com.devsuperior.dslist_game.services;

import com.devsuperior.dslist_game.dto.GameDTO;
import com.devsuperior.dslist_game.dto.GameListDTO;
import com.devsuperior.dslist_game.dto.GameMinDTO;
import com.devsuperior.dslist_game.entities.Game;
import com.devsuperior.dslist_game.entities.GameList;
import com.devsuperior.dslist_game.projections.GameMinProjection;
import com.devsuperior.dslist_game.repositories.GameListRepository;
import com.devsuperior.dslist_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(g -> new GameListDTO(g)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
