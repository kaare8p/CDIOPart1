package tests;

import java.awt.Color;
import boundaryToMatador.Car;
import boundaryToMatador.GUI;

public class CarTest {
    
    public static void main(String[] args) {
        Car car = new Car.Builder()
            .typeRacecar()
            .primaryColor(Color.BLUE)
            .secondaryColor(Color.RED)
            .patternDiagonalDualColor()
            .build();
        GUI.addPlayer("Sebastian Vettel", 25000, car);
    }
}
