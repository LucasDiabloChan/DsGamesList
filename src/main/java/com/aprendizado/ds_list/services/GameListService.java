package com.aprendizado.ds_list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendizado.ds_list.dto.GameListDTO;
import com.aprendizado.ds_list.entities.GameList;
import com.aprendizado.ds_list.projections.GameMinProjection;
import com.aprendizado.ds_list.repositories.GameListRepository;
import com.aprendizado.ds_list.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public void move(Long listId, int originalIndex, int destinationIndex) {
		List<GameMinProjection> gameList = gameRepository.searchByList(listId);

		GameMinProjection removedGame = gameList.remove(originalIndex);
		gameList.add(destinationIndex, removedGame);

		int min = originalIndex < destinationIndex ? originalIndex : destinationIndex;
		int max = originalIndex > destinationIndex ? originalIndex : destinationIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
		}
	}
}
