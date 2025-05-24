package com.roach43.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roach43.dslist.dto.GameMinDTO;
import com.roach43.dslist.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
