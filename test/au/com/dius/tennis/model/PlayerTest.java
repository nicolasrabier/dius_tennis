package au.com.dius.tennis.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	String playerName = "player 1";

	@Test
	public void createPlayerTest() {
		Player p = new Player(playerName);
		assertEquals("The player name should be " + playerName, playerName, p.getName());
		assertEquals("The point should be 0", new Integer(0), new Integer(p.getPoint()));
	}

	@Test
	public void managePlayerPointsTest() {
		Player p = new Player(playerName);
		p.addOnePoint();
		assertEquals("The point should be 1", new Integer(1), new Integer(p.getPoint()));
	}

}
