package com.techlabs.tic.tac.toe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.tic.tac.toe.game.Board;
import com.techlabs.tic.tac.toe.game.Game;
import com.techlabs.tic.tac.toe.game.Mark;
import com.techlabs.tic.tac.toe.game.Player;
import com.techlabs.tic.tac.toe.game.ResultAnalyzer;

public class TestGame {

	@Test
	public void testPlay() {
		Player p1=new Player("Dheeraj", Mark.O);
		Player p2=new Player("Prasad", Mark.X);
		
		Board board=new Board();
		
		ResultAnalyzer resultAnalyzer=new ResultAnalyzer(board);
		
		Game g=new Game(p1, p2, board, resultAnalyzer);
		g.play(1);
		g.play(2);
		
		assertEquals(Mark.O, board.getCells()[0].getMark());
		assertEquals(Mark.X, board.getCells()[1].getMark());
	}

	@Test
	public void testGetResult() {
		
		Player p1=new Player("Dheeraj", Mark.O);
		Player p2=new Player("Prasad", Mark.X);
		
		Board board=new Board();
		
		ResultAnalyzer resultAnalyzer=new ResultAnalyzer(board);
		
		Game g=new Game(p1, p2, board, resultAnalyzer);
		g.play(1);
		g.play(2);
		g.play(3);
		g.play(4);
		g.play(6);
		g.play(5);
		g.play(8);
		g.play(7);
		//g.play(9);
		
		//assertEquals(Status.Win, g.getGameStatus());
		assertEquals("Dheeraj", g.getCurrentPlayer().getName());
		
	}

}
