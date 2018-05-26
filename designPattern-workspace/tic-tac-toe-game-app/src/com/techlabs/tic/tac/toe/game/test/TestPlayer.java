package com.techlabs.tic.tac.toe.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlabs.tic.tac.toe.game.Mark;
import com.techlabs.tic.tac.toe.game.Player;

public class TestPlayer {

	@Test
	public void testPlayer() {
		
		Player player=new Player("Dheeraj", Mark.O);
		
		assertEquals("Dheeraj", player.getName());
		assertEquals(Mark.O, player.getMarkChoice());
		
	}
	

}
