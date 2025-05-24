package com.roach43.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roach43.dslist.dto.GameDTO;
import com.roach43.dslist.dto.GameMinDTO;
import com.roach43.dslist.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream()
                .map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        return gameRepository.findById(id)
                .map(GameDTO::new)
                .orElseThrow(()-> new RuntimeException("Game not found"));
    }
}
