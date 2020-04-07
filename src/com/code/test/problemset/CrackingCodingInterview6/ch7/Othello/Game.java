package com.code.test.problemset.CrackingCodingInterview6.ch7.Othello;

/**
 * Othello:
 *    Othello is played as follows:
 * 	  Each Othello piece is white on one side and black on the other.
 * 	  When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom,
 * 	  it is said to be captured and its color is flipped.
 * 	  On your turn, you must capture at least one of your opponent's pieces.
 * 	  The game ends when either user has no more valid moves.
 * 	  The win is assigned to the person with the most pieces.
 * 	  Implement the object-oriented design for Othello.
 */
public class Game {
	private Player[] players;
	private static Game instance;
	private Board board;
	private final int ROWS = 10;
	private final int COLUMNS = 10;
	
	private Game() {
		board = new Board(ROWS, COLUMNS);
		players = new Player[2];
		players[0] = new Player(Color.Black);
		players[1] = new Player(Color.White);
		Automator.getInstance().initialize(players); // used for testing
	}
	
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	public Board getBoard() {
		return board;
	}
}
