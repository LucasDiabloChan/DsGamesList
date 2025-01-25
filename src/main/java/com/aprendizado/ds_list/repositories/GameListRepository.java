package com.aprendizado.ds_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendizado.ds_list.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
