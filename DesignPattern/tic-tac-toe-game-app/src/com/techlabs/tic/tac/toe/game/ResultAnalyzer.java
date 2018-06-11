package com.techlabs.tic.tac.toe.game;

public class ResultAnalyzer {
	
	private Board board;

	public ResultAnalyzer(Board board) {
		this.board = board;
	}
	
	public Status analyzeBoard(){
		
		Status status = Status.Progress;
	
		if(this.board.isFull())
			status = Status.Draw;
		
		if(this.board.isEmpty())
			status = Status.Play;
		
		if(isWin())
			status = Status.Win;
		
		return status;
	}
	
	private boolean isWin(){
		
		if(checkHorizontal()!=null || checkVertical()!=null  || checkDiagonal()!=null)
			return true;
		
		return false;
		
	}
	
	private Mark checkHorizontal(){
		
		for(int i=0; i<this.board.getCells().length; i+=3)
			if(this.board.getCells()[i].getMark()==this.board.getCells()[i+1].getMark() 
			&& this.board.getCells()[i+1].getMark()==this.board.getCells()[i+2].getMark())
				return this.board.getCells()[i].getMark();
		
		return null;
		
	}
	
	private Mark checkVertical(){
		
		for(int i=0; i<this.board.getCells().length/3; i++)
			if(this.board.getCells()[i].getMark()==this.board.getCells()[i+3].getMark() 
			&& this.board.getCells()[i+3].getMark()==this.board.getCells()[i+6].getMark())
				return this.board.getCells()[i].getMark();
		
		return null;
		
	}
	
	private Mark checkDiagonal(){
		
		if(this.board.getCells()[0].getMark()==this.board.getCells()[4].getMark() 
				&& this.board.getCells()[4].getMark()==this.board.getCells()[8].getMark())
					return this.board.getCells()[0].getMark();
			
			if(this.board.getCells()[2].getMark()==this.board.getCells()[4].getMark() 
					&& this.board.getCells()[4].getMark()==this.board.getCells()[6].getMark())
				return this.board.getCells()[2].getMark();
		
		return null;
		
	}

}
