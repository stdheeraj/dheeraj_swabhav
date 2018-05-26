package com.techlabs.tic.tac.toe.game;

public class Player {
	
	private String name;
	private Mark markChoice;
	
	public Player(String name, Mark markChoice) {
			this.name = name;
			this.markChoice = markChoice;
	}
	
	public String getName() {
		return name;
	}
	
	public Mark getMarkChoice() {
		return markChoice;
	}
	
}
