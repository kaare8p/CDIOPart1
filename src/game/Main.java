//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 1 to start and end the game
//********************************************************************

package game;

public class Main {
	public static void main(String[] args) {
		//Creates Player, Dice and Engine objects
		Player player = new Player();
		Dice dice = new Dice();
		Engine engine = new Engine();
		//Keep track of current player, starts with player 1
		int currentPlayer = 1;
		
		boolean won = false;
		dice.setBoard();
		//While no one has won the game
		System.out.println("Score:\t\t\t\t\t\t\tPlayer 1\tPlayer 2");
		while (!won) {
			System.out.println("Player "+ currentPlayer + "s turn. Press enter to roll dice.");
			
			//Gives 1 turn to the current player
			won = engine.throwDice(player, dice, currentPlayer);
			//Change player
			currentPlayer = changePlayer(currentPlayer);
			}
	}
	
	//Method to change the player
	public static int changePlayer(int currentPlayer) {
		if (currentPlayer == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}
}
