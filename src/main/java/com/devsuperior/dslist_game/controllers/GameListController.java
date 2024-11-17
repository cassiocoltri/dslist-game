package com.devsuperior.dslist_game.controllers;

import com.devsuperior.dslist_game.dto.GameDTO;
import com.devsuperior.dslist_game.dto.GameListDTO;
import com.devsuperior.dslist_game.dto.GameMinDTO;
import com.devsuperior.dslist_game.dto.ReplacementDTO;
import com.devsuperior.dslist_game.services.GameListService;
import com.devsuperior.dslist_game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private  GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinantionIndex());
    }
}
