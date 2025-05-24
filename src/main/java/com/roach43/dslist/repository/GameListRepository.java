package com.roach43.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roach43.dslist.model.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
