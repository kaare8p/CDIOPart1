package test;

import java.util.Scanner;

public class TestGame {
	public static void main(String[] args) {
		//Creates Player, Dice and Engine objects
		Player player = new Player();
		Dice dice = new Dice();
		Engine engine = new Engine();
		//Keep track of if any of the players have won a game
		int won1 = 0;
		int won2 = 0;
		//Count the wins
		int wonCountEqual1 = 0;
		int wonCountSixes1 = 0;
		int wonCountEqual2 = 0;
		int wonCountSixes2 = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("TEST THE GAME");
		System.out.println("How many games do you wish to play?");
		int numberOfGames = sc.nextInt();
		
		//Play the game numberOfGames times, and record the result
		for (int i = 0; i < numberOfGames; i++) {
			do {
				won1 = engine.throwDice(player, dice, 1);
				if (won1 != 0) {
					if (won1 == 1) {
						wonCountEqual1++;
					}
					else {
						wonCountSixes1++;
					}
					player = new Player();
					dice = new Dice();
				}
				else {
					won2 = engine.throwDice(player, dice, 2);
					if (won2 != 0) {
						if (won2 == 1) {
							wonCountEqual2++;
						}
						else {
							wonCountSixes2++;
						}
						player = new Player();
						dice = new Dice();
					}
				}
			} while (won1 == 0 && won2 == 0);
		}
		//Present the result to the user
		int totalWins1 = wonCountEqual1 + wonCountSixes1;
		int totalWins2 = wonCountEqual2 + wonCountSixes2;
		
		System.out.println("\n\nPlayer 1 won " + totalWins1 + " times and player 2 won " + totalWins2 + " times!\n");
		
		System.out.println("Player 1 won " + wonCountEqual1 + " times by having a score above 40, and " + wonCountSixes1 + " times by throwing two sixes in a row!");
		System.out.println("Player 2 won " + wonCountEqual2 + " times by having a score above 40, and " + wonCountSixes2 + " times by throwing two sixes in a row!");
		sc.close();

	}
}
