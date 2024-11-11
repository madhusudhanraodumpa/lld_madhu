package com.design.elevator.model;

import com.design.elevator.controller.ElevatorController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElevatorCarManager {
    private List<ElevatorCar> elevatorCars;
    public static ElevatorCarManager INSTANCE;
    public Map<Integer,ElevatorCar> elevatorCarMap;
    public Map<Integer, ElevatorController> elevatorControllerMap;
    private ElevatorCarManager(){
        this.elevatorCarMap = new HashMap<>();
        this.elevatorControllerMap = new HashMap<>();
    }

    public static ElevatorCarManager getElevatorCarManager() {
        if (INSTANCE==null){
            INSTANCE=new ElevatorCarManager();
        }
        return INSTANCE;
    }
    public void initializeElevatorCarAndController(int numberOfElevators) {
        System.out.println("Initializing elevator system with " + numberOfElevators + " elevators!");
        System.out.println("--------------------------------------------------------");
        for(int elevatorId=1;elevatorId<=numberOfElevators;elevatorId++) {
            ElevatorCar elevatorCar = new ElevatorCar(elevatorId);
            elevatorCarMap.put(elevatorId,elevatorCar);

            elevatorControllerMap.put(elevatorId,elevatorCar.getElevatorController());

        }
    }
    public  ElevatorCar getElevatorCar(int elevatorNumber) {
        return INSTANCE.elevatorCarMap.get(elevatorNumber);
    }

    public ElevatorController getElevatorController(int elevatorNumber) {
        return elevatorControllerMap.get(elevatorNumber);
    }
    public void removeElevatorCar(int elevatorNumber) {

    }
    public void addElevatorCar(int elevatorCarNumber) {

    }
}
