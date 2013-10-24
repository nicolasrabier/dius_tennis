package au.com.dius.tennis.model;

public class Game {
	
	private NormalScorer scorerSystem;

	public Game(String player1, String player2) {
		scorerSystem = new NormalScorer(new Player(player1), new Player(player2));
	}
	
	public void pointWonBy(String winnerName){
		scorerSystem = scorerSystem.pointWonBy(winnerName);
	}
	
	public String getScore(){
		if(scorerSystem.isGameFinished()){
			return scorerSystem.getWinnerOfGame();
		}else{
			return scorerSystem.getScore();
		}
	}

}
