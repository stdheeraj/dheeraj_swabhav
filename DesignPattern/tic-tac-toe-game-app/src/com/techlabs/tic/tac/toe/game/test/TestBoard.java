package com.techlabs.tic.tac.toe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.tic.tac.toe.game.Board;
import com.techlabs.tic.tac.toe.game.Mark;

public class TestBoard {

	@Test
	public void testBoard() {
		Board board=new Board();
		assertEquals(board.getCells().length, 9);
	}

	@Test
	public void testGetCells() {
		
		Board board=new Board();
		
		board.setCell(9, Mark.O);
		assertEquals(board.getCells()[8].getMark(), Mark.O);
		
	}

	@Test
	public void testSetCell() {
		
		Board board=new Board();
		
		board.setCell(5, Mark.O);
		assertEquals(board.getCells()[4].getMark(), Mark.O);
		
		//board.setCell(5, Mark.X);
		//assertEquals(board.getCells()[4].getMark(), Mark.X);
	}
	
	@Test
	public void testIsEmpty(){
		
		Board board=new Board();
		
		board.setCell(9, Mark.O);
		assertEquals(false, board.isEmpty());
	}
	
	@Test
	public void testIsFull(){
		
		Board board=new Board();
		
		board.setCell(1, Mark.O);
		board.setCell(2, Mark.X);
		board.setCell(3, Mark.X);
		board.setCell(4, Mark.O);
		board.setCell(5, Mark.O);
		board.setCell(6, Mark.X);
		board.setCell(7, Mark.O);
		board.setCell(8, Mark.X);
		board.setCell(9, Mark.O);
		assertEquals(true, board.isFull());
	}

}
