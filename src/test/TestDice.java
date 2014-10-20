//********************************************************************
//  Test.java       Authors: Group 57
//
//  Class used for testing the game
//********************************************************************

package test;

import java.util.Scanner;

public class TestDice {

	public static void main(String[] args) {
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		int equals = 0;
		Scanner sc = new Scanner(System.in);
		
		double percent = 0;
		double[] expectedPercent = new double[13];
		expectedPercent[2] = 2.77777;
		expectedPercent[3] = 5.55555;
		expectedPercent[4] = 8.33333;
		expectedPercent[5] = 11.11111;
		expectedPercent[6] = 13.88888;
		expectedPercent[7] = 16.66666;
		expectedPercent[8] = 13.88888;
		expectedPercent[9] = 11.11111;
		expectedPercent[10] = 8.33333;
		expectedPercent[11] = 5.55555;
		expectedPercent[12] = 2.77777;
		
		
		int[] eyes = new int[13];
		for (int i = 0; i < eyes.length; i++) {
			eyes[i] = 0;
		}

		System.out.println("DICE TEST");
		System.out.println("How many times do you wish to throw the dice?");
		int numberOfThrows = sc.nextInt();
		
		//Throw the dice numberOfThrows times, and record the result in variables
		for (int i = 0; i < numberOfThrows; i++) {
			if(d1.getDice1() == d2.getDice2()){
				equals++;
			}
			
			for (int j = 2; j < eyes.length; j++) {
				if (d1.getDice1() + d2.getDice2() == j) {
					eyes[j] = eyes[j] + 1;
				}
			}
		}
		
		//Calculate the percentage of each value from 2-12 and present
		//the recorded data as a table to the user, compared to the expected values
		System.out.println("Eyes\t\t\tOccurrences\t\tPercent\t\t\tExpected percent");
		for (int i = 2; i < eyes.length; i++) {
			percent = (double) 100 * (double) eyes[i] / (double) numberOfThrows;
			System.out.println(i + "\t\t\t" + eyes[i] + "\t\t\t" + percent + "	\t\t" + expectedPercent[i]);
		}
		
		System.out.println("\nAmount of equals " + equals);
		System.out.println("Chance for two of a kind is 16.67 %.");
		System.out.println("% of throws that are two of a kind is " + ((double) 100 * (double) equals / (double) numberOfThrows) + " %");
		
		sc.close();
	}

}
