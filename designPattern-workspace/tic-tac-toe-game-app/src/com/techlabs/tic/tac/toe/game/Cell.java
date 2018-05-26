package com.techlabs.tic.tac.toe.game;

public class Cell {
	
	private Mark mark;

	public Mark getMark() {
		return mark;
	}

	public boolean setMark(Mark mark) {
		
		if(this.mark==null){
			this.mark = mark;
			return true;
		}
		
		System.out.println("Already marked.");
		
		return false;
	}

}
