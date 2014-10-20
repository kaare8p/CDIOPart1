//********************************************************************
//  Engine.java       Authors: Group 57
//
//  A class to hold methods to run the game in CDIO part 1
//********************************************************************

package test;

public class Engine {
	private int diceSum;
	private boolean sixesPreviouslyThrown = false;
	
	//A method to throw the dice, and either return or 
	//hand the result over to another method based on the dice
	//Returns 0 if not won,
	//1 if won by score above 40 and equal dice thrown, 
	//2 if won by two  sixes thrown two times in a row
	public int throwDice(Player player, Dice dice, int currentPlayer) {
		//Roll the dice and add point to player
		diceSum = dice.getSum();
		player.addPoints(currentPlayer, diceSum);
		
		//If the dice are equal, hand the result over to equalDiceThrown()
		if (dice.getEqual()) {
			return this.equalDiceThrown(player, dice, currentPlayer);
		}
		//Sixes was not thrown
		sixesPreviouslyThrown = false;
		return 0;
	}
	//Method used if the dice are equal
	private int equalDiceThrown(Player player, Dice dice, int currentPlayer) {
		//If the dice thrown are ones, hand the result over to ones()
		if (dice.getOnes()) {
			this.ones(player, currentPlayer);
			sixesPreviouslyThrown = false;
			
			//Throw dice again
			return this.throwDice(player, dice, currentPlayer);
		}
		
		//If the score of the player is greater than or equal to 40, win the game
		else if (player.getScore(currentPlayer) >= 40) {
			sixesPreviouslyThrown = false;
			return 1;
		}
		
		//If the dice thrown are two sixes
		else if (dice.getSixes()) {
			//If the previously thrown was two sixes, win game 
			if (sixesPreviouslyThrown) {
				return 2;
			}
			//Else set sixesPreviouslyThrown to true, and throw dice again
			else {
				sixesPreviouslyThrown = true;
				return this.throwDice(player, dice, currentPlayer);
			}
		}
		//If any other value, set sixesPreviouslyThrown to false, and throw dice again 
		sixesPreviouslyThrown = false;
		return this.throwDice(player, dice, currentPlayer);
	}
	
	//Method use if the dice thrown are two ones
	private void ones(Player player, int currentPlayer) {
		//Set the score of the player to 0
		player.setZero(currentPlayer);
	}
}