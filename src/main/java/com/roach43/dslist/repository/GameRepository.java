package com.roach43.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roach43.dslist.model.Game;


public interface GameRepository extends JpaRepository<Game, Long> {
    

}
