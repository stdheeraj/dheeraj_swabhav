package com.techlabs.tic.tac.toe.game.gui;

import java.awt.EventQueue;

public class TestGUI {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGUI frame = new TicTacToeGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
