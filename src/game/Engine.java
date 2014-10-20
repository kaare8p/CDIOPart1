//********************************************************************
//  Engine.java       Authors: Group 57
//
//  A class to hold methods to run the game in CDIO part 1
//********************************************************************

package game;

import java.util.Scanner;

public class Engine {
	private Scanner keyboard = new Scanner(System.in);
	private int diceSum;
	private boolean sixesPreviouslyThrown = false;
	
	//A method to throw the dice, and either return or 
	//hand the result over to another method based on the dice
	public boolean throwDice(Player player, Dice dice, int currentPlayer) {
		//Wait for enter pressed
		keyboard.nextLine();
		//Roll the dice and add point to player
		diceSum = dice.getSum();
		player.addPoints(currentPlayer, diceSum);
		
		System.out.println(diceSum + " thrown!");
		if (currentPlayer == 1) {
			System.out.println("Player "+ currentPlayer +" now has a score of\t\t\t\t" + player.getScore(currentPlayer));
		}
		else {
			System.out.println("Player "+ currentPlayer +" now has a score of\t\t\t\t\t\t" + player.getScore(currentPlayer));
		}
		
		//If the dice are equal, hand the result over to equalDiceThrown()
		if (dice.getEqual()) {
			return this.equalDiceThrown(player, dice, currentPlayer);
		}
		//Sixes was not thrown
		sixesPreviouslyThrown = false;
		return false;
	}
	//Method used if the dice are equal
	private boolean equalDiceThrown(Player player, Dice dice, int currentPlayer) {
		//If the dice thrown are ones, hand the result over to ones()
		if (dice.getOnes()) {
			this.ones(player, currentPlayer);
			sixesPreviouslyThrown = false;
			
			System.out.println("Equal pair of dice thrown! Press enter to throw again");
			//Throw dice again
			return this.throwDice(player, dice, currentPlayer);
		}
		
		//If the score of the player is greater than or equal to 40, win the game
		else if (player.getScore(currentPlayer) >= 40) {
			sixesPreviouslyThrown = false;
			System.out.println("Player " + currentPlayer + " threw two equal dice with a score greater than or equal to 40, and won the game!");
			return true;
		}
		
		//If the dice thrown are two sixes
		else if (dice.getSixes()) {
			//If the previously thrown was two sixes, win game 
			if (sixesPreviouslyThrown) {
				System.out.println("Two sixes thrown two times in a row! Game won by player " + currentPlayer);
				return true;
			}
			//Else set sixesPreviouslyThrown to true, and throw dice again
			else {
				sixesPreviouslyThrown = true;
				System.out.println("Equal pair of dice thrown! Press enter to throw again");
				return this.throwDice(player, dice, currentPlayer);
			}
		}
		//If any other value, set sixesPreviouslyThrown to false, and throw dice again 
		sixesPreviouslyThrown = false;
		System.out.println("Equal pair of dice thrown! Press enter to throw again");
		return this.throwDice(player, dice, currentPlayer);
	}
	
	//Method use if the dice thrown are two ones
	private void ones(Player player, int currentPlayer) {
		System.out.println("Two ones thrown, score reset!");
		//Set the score of the player to 0
		player.setZero(currentPlayer);
	}
}