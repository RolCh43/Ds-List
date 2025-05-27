package com.roach43.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roach43.dslist.dto.GameListDTO;
import com.roach43.dslist.projections.GameMinProjection;
import com.roach43.dslist.repository.GameListRepository;
import com.roach43.dslist.repository.GameRepository;


@Service
public class GameListService {

     @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection game = list.remove(sourceIndex);
        list.add(destinationIndex, game);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }


}
