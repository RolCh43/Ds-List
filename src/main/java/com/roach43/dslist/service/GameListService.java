package com.roach43.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roach43.dslist.dto.GameListDTO;
import com.roach43.dslist.repository.GameListRepository;


@Service
public class GameListService {

     @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .toList();
    }


}
