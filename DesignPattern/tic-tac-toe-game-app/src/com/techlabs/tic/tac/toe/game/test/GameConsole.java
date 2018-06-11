package com.techlabs.tic.tac.toe.game.test;

import java.util.Scanner;

import com.techlabs.tic.tac.toe.game.Board;
import com.techlabs.tic.tac.toe.game.Game;
import com.techlabs.tic.tac.toe.game.Mark;
import com.techlabs.tic.tac.toe.game.Player;
import com.techlabs.tic.tac.toe.game.ResultAnalyzer;
import com.techlabs.tic.tac.toe.game.Status;

public class GameConsole {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Player1, enter your name: ");
		String player1Name = sc.next();
		System.out.print("Player1, enter 0 for Nought Mark or 1 for Cross Mark: ");
		int player1Mark = sc.nextInt();

		System.out.print("Player2, enter your name: ");
		String player2Name = sc.next();

		Player player1, player2;

		if (player1Mark == 0) {
			player1 = new Player(player1Name, Mark.O);
			player2 = new Player(player2Name, Mark.X);
		} else {
			player1 = new Player(player1Name, Mark.X);
			player2 = new Player(player2Name, Mark.O);
		}
		
		do{
			
			Board board = new Board();
			ResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
			Game g = new Game(player1, player2, board, resultAnalyzer);
			
			System.out.println("Start playing");
			displayBoard(g);
			
			while (g.getGameStatus() == Status.Progress || g.getGameStatus() == Status.Play) {
				
				System.out.print(g.getCurrentPlayer().getName() + ", enter position to be marked: ");
				g.play(sc.nextInt());
				displayBoard(g);
				
			}
			
			if(g.getGameStatus() == Status.Win)
				System.out.println("Congratulation ! " + g.getCurrentPlayer().getName() + ", you won the game.");
			else
				System.out.println("Game over, since it's draw.");
			
			System.out.print("If you want to play again, then enter 1 otherwise 0: ");
			if(sc.nextInt() == 0)
				break;
			
		}while(true);
		
		sc.close();
		
	}

	private static void displayBoard(Game g) {

		for (int i = 0; i < g.getBoard().getCells().length; i++) {
			if (g.getBoard().getCells()[i].getMark() != null)
				System.out.print(" " + g.getBoard().getCells()[i].getMark() + " ");
			else
				System.out.print(" " + (i + 1) + " ");

			if (i == 2 || i == 5)
				System.out.println("\n-----------");
			else if (i == 8)
				System.out.println();
			else
				System.out.print("|");

		}

		System.out.println("Game status: " + g.getGameStatus());

	}

}
