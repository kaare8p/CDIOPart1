package tests;

import java.awt.Color;
import java.util.ArrayList;
import boundaryToMatador.Car;
import boundaryToMatador.Field;
import boundaryToMatador.GUI;
import boundaryToMatador.*;

public class TestCreate {
    
    public static void main(String[] args) {
        ArrayList<Field> list = new ArrayList<Field>();
        
        list.add(new Start.Builder().build());
        list.add(new Tax.Builder().build());
        list.add(new Street.Builder().build());
        list.add(new Shipping.Builder().build());
        list.add(new Refuge.Builder().build());
        list.add(new Jail.Builder().build());
        list.add(new Chance.Builder().build());
        list.add(new Brewery.Builder().build());
        
        Field[] fields = new Field[list.size()];
        for(int i = 0; i < fields.length; i++) fields[i] = list.get(i);
      
        GUI.create(fields);
        Car car = new Car.Builder()
            .typeRacecar()
            .primaryColor(Color.BLUE)
            .secondaryColor(Color.RED)
            .patternDiagonalDualColor()
            .build();
        GUI.addPlayer("Sebastian Vettel", 25000, car);
    }
}
