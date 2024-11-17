package com.devsuperior.dslist_game.services;

import com.devsuperior.dslist_game.dto.GameDTO;
import com.devsuperior.dslist_game.dto.GameMinDTO;
import com.devsuperior.dslist_game.entities.Game;
import com.devsuperior.dslist_game.projections.GameMinProjection;
import com.devsuperior.dslist_game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    // A anotação Transactional do spring quando colocado readoonly true ele está avisando que é só
    // "Leitura". não vai escrever nada no banco ou fazer qualquer alteração, vai deixar o cod mais rápido.
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(g -> new GameMinDTO(g)).toList();

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(g -> new GameMinDTO(g)).toList();

    }

}
