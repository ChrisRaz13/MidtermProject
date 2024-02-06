package com.skilldistillery.gamequest.data;

import java.util.List;

import com.skilldistillery.gamequest.entities.GameCharacter;

public interface CharacterDAO {
	
	public List<GameCharacter> getAllCharacters();
	
	public List<GameCharacter> getCharactersByGameId();
	
	public GameCharacter getCharacterById(int id);

}
