package com.aprendizado.ds_list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendizado.ds_list.dto.GameListDTO;
import com.aprendizado.ds_list.entities.GameList;
import com.aprendizado.ds_list.repositories.GameListRepository;


// Both can be used to identify this class as an component
@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO (x)).toList();
	}
}
