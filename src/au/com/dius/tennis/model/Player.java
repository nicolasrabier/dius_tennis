package au.com.dius.tennis.model;

public class Player {

	private String name = "";
	private int point = 0;

	public Player(String player) {
		this.name = player;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	public void addOnePoint() {
		point++;
	} 

}
