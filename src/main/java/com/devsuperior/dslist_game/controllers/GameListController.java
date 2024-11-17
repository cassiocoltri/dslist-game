package com.devsuperior.dslist_game.controllers;

import com.devsuperior.dslist_game.dto.GameDTO;
import com.devsuperior.dslist_game.dto.GameListDTO;
import com.devsuperior.dslist_game.dto.GameMinDTO;
import com.devsuperior.dslist_game.services.GameListService;
import com.devsuperior.dslist_game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }
}
