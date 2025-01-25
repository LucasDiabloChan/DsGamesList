package com.aprendizado.ds_list.dto;

import com.aprendizado.ds_list.entities.GameList;

public class GameListDTO {
	private Long id;
	private String name;
	
	public GameListDTO() {
	}
	
	public GameListDTO(GameList games) {
		id = games.getId();
		name = games.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
