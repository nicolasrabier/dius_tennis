package au.com.dius.tennis.model;

public class Game {

	private final String[] SCORE_REF = { "0", "15", "30", "40" };
	private final String DEUCE = "Deuce";
	private final String ADVANTAGE = "Advantage";
	private final String WINS = " wins";
	private final int END_GAME_POINT = 4;
	private final int POINT_DIFF = 2;

	private Player player1;
	private Player player2;

	public Game(String player1, String player2) {
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
	}

	/**
	 * The function updates the score of the game
	 * 
	 * @param playerName
	 *            player name who wins the point
	 */
	public void pointWonBy(String playerName) {
		if (playerName != null && player1.getName().equals(playerName.trim())) {
			player1.addOnePoint();
		} else {
			player2.addOnePoint();
		}
	}

	/**
	 * The function displays the score of the game
	 * 
	 * @return String the score of the game
	 */
	public String getScore() {
		String res = "";
		// point difference between players
		int delta = player1.getPoint() - player2.getPoint();
		
		// player1 has already reached at least 4 points and has more than 2 points difference with player2
		if (delta >= POINT_DIFF && player1.getPoint() >= END_GAME_POINT) {
			res = player1.getName() + WINS;

		// player2 has already reached at least 4 points and has more than 2 points difference with player1
		} else if (delta <= (POINT_DIFF * -1) && player2.getPoint() >= END_GAME_POINT) {
			res = player2.getName() + WINS;

		// both players have same number of points and each has reached 3 points (40) at least
		} else if (delta == 0 && player1.getPoint() >= (END_GAME_POINT - 1)) {
			res = DEUCE;

		// normal score
		} else if (player1.getPoint() < END_GAME_POINT && player2.getPoint() < END_GAME_POINT) {
			res = SCORE_REF[player1.getPoint()] + "-" + SCORE_REF[player2.getPoint()];

		// advantage player1
		} else if (player1.getPoint() > player2.getPoint()) {
			res = ADVANTAGE + " " + player1.getName();

		// advantage player2
		} else if (player2.getPoint() > player1.getPoint()) {
			res = ADVANTAGE + " " + player2.getName();
		}
		return res;
	}

}
