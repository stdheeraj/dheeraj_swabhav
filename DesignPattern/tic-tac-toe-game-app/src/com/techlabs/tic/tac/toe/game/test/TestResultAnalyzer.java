package com.techlabs.tic.tac.toe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.tic.tac.toe.game.Board;
import com.techlabs.tic.tac.toe.game.Mark;
import com.techlabs.tic.tac.toe.game.ResultAnalyzer;
import com.techlabs.tic.tac.toe.game.Status;

public class TestResultAnalyzer {

	@Test
	public void testResultAnalyzer() {
		
		Board board=new Board();
		
		ResultAnalyzer analyze=new ResultAnalyzer(board);
		analyze.analyzeBoard();
		
		assertEquals(Status.Play, analyze.analyzeBoard());
	}

	@Test
	public void testAnalyzeBoard() {
		
		Board board=new Board();
		
		board.setCell(1, Mark.X);
		board.setCell(2, Mark.O);
		board.setCell(3, Mark.O);
		board.setCell(4, Mark.O);
		board.setCell(5, Mark.O);
		board.setCell(6, Mark.X);
		board.setCell(7, Mark.X);
		board.setCell(8, Mark.X);
		board.setCell(9, Mark.O);
		
		ResultAnalyzer analyze=new ResultAnalyzer(board);
		
		assertEquals(Status.Draw, analyze.analyzeBoard());
		
	}

}
