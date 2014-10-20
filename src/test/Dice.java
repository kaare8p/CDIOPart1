//********************************************************************
//Dice.java       Authors: Group 57
//
//A class to hold information and methods regarding the dice in CDIO part 1
//********************************************************************

package test;

import boundaryToMatador.GUI;

public class Dice {
private int dice1;
private int dice2;

//Object that stores the value of the two dice
public Dice() {
	dice1 = 0;
	dice2 = 0;
}

public void setBoard() {
	GUI.setDice(1, 1);
}

//Public get method that generates two random integers between 1 and 6, 
//places two dice with these values on the board, and returns the sum. 
public int getSum() {
	dice1 = (int) (Math.random() * 6 + 1);
	dice2 = (int) (Math.random() * 6 + 1);
	GUI.setDice(dice1, dice2);
	return dice1 + dice2;
}

//Get dice1 from 1-6
public int getDice1(){
	dice1 = (int)(Math.random()*6)+1;
	return dice1;
}

//Get dice2 from 1-6
public int getDice2(){
	dice2 = (int)(Math.random()*6)+1;
	return dice2;
}


//Public get method that returns true if the dice are equal
public boolean getEqual() {
	if (dice1 == dice2) {
		return true;
	}
	else {
		return false;
	}
}

//Public get method that returns true if both dice are ones
public boolean getOnes() {
	if (dice1 == 1 && dice2 == 1) {
		return true;
	}
	else {
		return false;
	}
}

//Public get method that returns true if both dice are sixes
public boolean getSixes() {
	if (dice1 == 6 && dice2 == 6) {
		return true;
	}
	else {
		return false;
	}
}
}
