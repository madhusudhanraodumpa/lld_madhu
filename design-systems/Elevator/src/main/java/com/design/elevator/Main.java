package com.design.elevator;

import com.design.elevator.model.*;
import com.design.elevator.stratgies.LookElevatorControlStrategy;
import com.design.elevator.stratgies.OddEvenElevatorSelectionStrategy;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.getElevatorSystem();
        elevatorSystem.initializeElevatorSystem(12, 4,new OddEvenElevatorSelectionStrategy(),new LookElevatorControlStrategy());
        Button button= new ExternalButton();

        System.out.println("--------------------------------------------------------");
        // Press external button from floor 10 to go down

        button.pressButton(Direction.DOWN,10,-1);


        System.out.println("--------------------------------------------------------");
        // Press internal button to move to floor 7 in elevator 4
        ElevatorCar elevatorCar= ElevatorCarManager.getElevatorCarManager().getElevatorCar(4);
        elevatorCar.pressButton(7);

        System.out.println("--------------------------------------------------------");

        System.out.println("Hello world!");
    }
}