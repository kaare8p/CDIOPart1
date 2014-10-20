package tests;

import java.awt.Color;

import boundaryToMatador.GUI;


/**
 * @author Daniel Kolditz Rubin-Gr�n
 */
public class TestRunExampleGame{

	public static void main(String[] args){
		realExampleGame();
	}

	private static void realExampleGame(){
		// Setup game
		sleep();
		GUI.addPlayer("Mads", 30000, Color.RED);
		sleep();
		GUI.addPlayer("Stig", 30000, Color.YELLOW);
		sleep();
		GUI.setCar(1, "Mads");
		sleep();
		GUI.setCar(1, "Stig");
		
		// Move player 1
		sleep();
		GUI.setDice(1, 2);
		sleep();
		GUI.removeAllCars("Mads");
		GUI.setCar(2, "Mads");
		sleep();
		GUI.removeAllCars("Mads");
		GUI.setCar(3, "Mads");
		sleep();
		GUI.removeAllCars("Mads");
		GUI.setCar(4, "Mads");
		sleep();
		GUI.setBalance("Mads", 28000);
		GUI.setOwner(4, "Mads");
		sleep();
	}
	public static void sleep(){
		sleep(1200);
	}
	public static void sleep(int n){
		long t0, t1;
		t0 = System.currentTimeMillis();
		do{
			t1 = System.currentTimeMillis();
		}
		while((t1 - t0) < (n));
	}
}