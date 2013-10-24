package au.com.dius.tennis.model;

public class DeuceScorer extends NormalScorer {

	private final String DEUCE = "Deuce";
	private final String ADVANTAGE = "Advantage";

	public DeuceScorer(Player player1, Player player2) {
		super(player1, player2);
	}

	@Override
	public String getScore() {
		String res = "";
		if (isDeuce()) {
			res = DEUCE;
		} else if (player1.getPoint() > player2.getPoint()) {
			res = ADVANTAGE + " " + player1.getName();
		} else if (player1.getPoint() < player2.getPoint()) {
			res = ADVANTAGE + " " + player2.getName();
		}
		return res;
	}

	private boolean isDeuce() {
		if (player1.getPoint() - player2.getPoint() == 0 && player1.getPoint() >= NORMAL_DEUCE_SCORER_LIMIT) {
			return true;
		}
		return false;
	}

}
