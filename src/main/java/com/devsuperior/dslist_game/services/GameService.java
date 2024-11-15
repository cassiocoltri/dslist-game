package com.devsuperior.dslist_game.services;

import com.devsuperior.dslist_game.dto.GameMinDTO;
import com.devsuperior.dslist_game.entities.Game;
import com.devsuperior.dslist_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(g -> new GameMinDTO(g)).toList();

    }

}
