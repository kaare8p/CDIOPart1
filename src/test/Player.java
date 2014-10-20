//********************************************************************
//  Player.java       Authors: Group 57
//
//  A class to hold information and methods regarding the player in CDIO part 1
//********************************************************************

package test;

public class Player {
	private int player1;
	private int player2;

	//Object that stores the score of the two players
	public Player() {
		player1 = 0;
		player2 = 0;
	}
	
	//Public get method to get the score of chosen player
	public int getScore(int player) {
		if (player == 1) {
			return player1;
		}
		else {
			return player2;
		}
	}
	
	//Public method to add points to chosen player
	public void addPoints(int player, int points) {
		if (player == 1) {
			player1 += points;
		}
		else {
			player2 += points;
		}
	}
	
	//Public set method to reset the score of chosen player
	public void setZero(int player) {
		if (player == 1) {
			player1 = 0;
		}
		else {
			player2 = 0;
		}
	}

}
