package com.techlabs.tic.tac.toe.game;

public class Game {

	private Player[] players;
	private Board board;
	private ResultAnalyzer resultAnalyzer;
	private Player currentPlayer;

	public Game(Player player1, Player player2, Board board, ResultAnalyzer resultAnalyzer) {
		this.players = new Player[2];
		this.players[0] = player1;
		this.players[1] = player2;
		this.currentPlayer = player1;
		this.board = board;
		this.resultAnalyzer = resultAnalyzer;
	}

	public boolean play(int position) {

		boolean markAck = this.board.setCell(position, this.currentPlayer.getMarkChoice());
		

		if((this.getGameStatus() == Status.Progress || this.getGameStatus() == Status.Play) && markAck){
			if(this.currentPlayer.equals(this.players[0]))
				this.currentPlayer = this.players[1];
			else
				this.currentPlayer = this.players[0];
		}

		return markAck;
	}


	public Status getGameStatus() {
		return this.resultAnalyzer.analyzeBoard();
	}

	public Player[] getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

	public ResultAnalyzer getResultAnalyzer() {
		return resultAnalyzer;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	

}
