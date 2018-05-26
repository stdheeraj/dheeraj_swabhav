package com.techlabs.tic.tac.toe.game.test;

import org.junit.Test;

import static org.junit.Assert.*;

import com.techlabs.tic.tac.toe.game.Cell;
import com.techlabs.tic.tac.toe.game.Mark;

public class TestCell {

	@Test
	public void testGetMark() {
		Cell cell=new Cell();
		cell.setMark(Mark.O);
		assertEquals(cell.getMark(), Mark.O);
	}

	@Test
	public void testSetMark() {
		
		Cell cell=new Cell();
		
		cell.setMark(Mark.X);
		assertEquals(cell.getMark(), Mark.X);
		
		cell.setMark(Mark.O);
		//assertEquals(cell.getMark(), Mark.O);
		
		
	}

}
