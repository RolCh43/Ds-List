package com.roach43.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roach43.dslist.dto.GameDTO;
import com.roach43.dslist.dto.GameMinDTO;
import com.roach43.dslist.service.GameService;


@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;
    
    
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

}
