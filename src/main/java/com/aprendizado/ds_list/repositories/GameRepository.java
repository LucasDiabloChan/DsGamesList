package com.aprendizado.ds_list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendizado.ds_list.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
