package au.com.dius.tennis.model;

public class NormalScorer {

	protected Player player1;
	protected Player player2;

	private final static String[] SCORE_REF = { "0", "15", "30", "40" };
	private final static int POINT_DIFF = 2;
	protected final static int NORMAL_DEUCE_SCORER_LIMIT = 3;

	private final static String WINS = " wins";

	public NormalScorer(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		return SCORE_REF[player1.getPoint()] + "-" + SCORE_REF[player2.getPoint()];
	}

	public NormalScorer pointWonBy(String winnerName) {
		if (!isGameFinished()) {
			if (winnerName != null && player1.getName().equals(winnerName.trim())) {
				player1.addOnePoint();
			} else {
				player2.addOnePoint();
			}
			if (switchToDeuceScoringSystem() && !(this instanceof DeuceScorer)) {
				return new DeuceScorer(player1, player2);
			}
		}
		return this;
	}

	public boolean isGameFinished() {
		int delta = player1.getPoint() - player2.getPoint();
		if ((delta >= POINT_DIFF || delta <= (POINT_DIFF * -1))
				&& (player1.getPoint() > NORMAL_DEUCE_SCORER_LIMIT || player2.getPoint() > NORMAL_DEUCE_SCORER_LIMIT)) {
			return true;
		}
		return false;
	}

	public String getWinnerOfGame() {
		if (isGameFinished()) {
			return player1.getPoint() > player2.getPoint() ? player1.getName() + WINS : player2.getName() + WINS;
		}
		return "";
	}

	private boolean switchToDeuceScoringSystem() {
		if (player1.getPoint() >= NORMAL_DEUCE_SCORER_LIMIT && player2.getPoint() >= NORMAL_DEUCE_SCORER_LIMIT) {
			return true;
		}
		return false;
	}

}
