package com.aprendizado.ds_list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aprendizado.ds_list.dto.GameMinDTO;
import com.aprendizado.ds_list.entities.Game;
import com.aprendizado.ds_list.repositories.GameRepository;

// Both can be used to identify this class as an component
@Service
@Component
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
