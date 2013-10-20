package au.com.dius.tennis.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	private String player1 = "player 1";
	private String player2 = "player 2";

	@Test
	public void player1WonGameTest() {
		Game game = new Game(player1, player2);
		game.pointWonBy(player1);
		assertEquals("The score should be 15-0", "15-0", game.getScore());

		game.pointWonBy(player1);
		assertEquals("The score should be 30-0", "30-0", game.getScore());

		game.pointWonBy(player1);
		assertEquals("The score should be 40-0", "40-0", game.getScore());

		game.pointWonBy(player1);
		assertEquals("The score should be " + player1 + " wins", player1 + " wins", game.getScore());
	}

	@Test
	public void player2WonGameTest() {
		Game game = new Game(player1, player2);
		game.pointWonBy(player2);
		assertEquals("The score should be 0-15", "0-15", game.getScore());

		game.pointWonBy(player2);
		assertEquals("The score should be 0-30", "0-30", game.getScore());

		game.pointWonBy(player2);
		assertEquals("The score should be 0-40", "0-40", game.getScore());

		game.pointWonBy(player2);
		assertEquals("The score should be " + player2 + " wins", player2 + " wins", game.getScore());
	}

	@Test
	public void deuceTest() {
		Game game = new Game(player1, player2);
		game.pointWonBy(player1);
		game.pointWonBy(player1);
		game.pointWonBy(player1);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		assertEquals("The score should be Deuce", "Deuce", game.getScore());
	}

	@Test
	public void advantagePlayer1AndLoseTest() {
		Game game = new Game(player1, player2);
		game.pointWonBy(player1);
		game.pointWonBy(player1);
		game.pointWonBy(player1);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		game.pointWonBy(player1);
		assertEquals("The score should be Advantage " + player1, "Advantage " + player1, game.getScore());

		game.pointWonBy(player2);
		assertEquals("The score should be Deuce ", "Deuce", game.getScore());

		game.pointWonBy(player2);
		assertEquals("The score should be Advantage " + player2, "Advantage " + player2, game.getScore());

		game.pointWonBy(player2);
		assertEquals("The score should be " + player2 + " wins", player2 + " wins", game.getScore());
	}

	@Test
	public void advantagePlayer2AndLostTest() {
		Game game = new Game(player1, player2);
		game.pointWonBy(player1);
		game.pointWonBy(player1);
		game.pointWonBy(player1);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		game.pointWonBy(player2);
		assertEquals("The score should be Advantage " + player2, "Advantage " + player2, game.getScore());

		game.pointWonBy(player1);
		assertEquals("The score should be Deuce ", "Deuce", game.getScore());

		game.pointWonBy(player1);
		assertEquals("The score should be Advantage " + player1, "Advantage " + player1, game.getScore());

		game.pointWonBy(player1);
		assertEquals("The score should be " + player1 + " wins", player1 + " wins", game.getScore());
	}

	@Test
	public void gitTest() {
		Game game = new Game(player1, player2);
		game.pointWonBy(player1);
		game.pointWonBy(player2);
		// this will return "15-15"
		assertEquals("The score should be 15-15", "15-15", game.getScore());

		game.pointWonBy("player 1");
		game.pointWonBy("player 1");
		// this will return "40-15"
		assertEquals("The score should be 40-15", "40-15", game.getScore());

		game.pointWonBy("player 2");
		game.pointWonBy("player 2");
		// this will return "Deuce"
		assertEquals("The score should be Deuce", "Deuce", game.getScore());

		game.pointWonBy("player 1");
		// this will return "Advantage player 1"
		assertEquals("The score should be Advantage " + player1, "Advantage " + player1, game.getScore());

		game.pointWonBy("player 1");
		// this will return "Player 1 wins" 
		assertEquals("The score should be " + player1 + " wins", player1 + " wins", game.getScore());
	}

}
