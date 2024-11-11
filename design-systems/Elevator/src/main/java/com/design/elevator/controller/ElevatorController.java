package com.design.elevator.controller;

import com.design.elevator.model.*;
import com.design.elevator.stratgies.ElevatorControlStrategy;

public class ElevatorController {

    private int id;
    private ElevatorCar elevatorCar;
    private ElevatorControlStrategy controlStrategy;
    private ElevatorCurrState elevatorCurrState;

    public ElevatorController() {
        this.controlStrategy=ElevatorSystem.getElevatorSystem().getElevatorControlStrategy();
        this.elevatorCurrState=new ElevatorCurrState();
    }

    public void moveElevatorToFloor(int floorNum) {

        //We are just determining the nex stop as when requests come
        //The movement is being taken by hardware.
        //Controller sees the next stop and tells hardware move to this floor
        int nextStop = controlStrategy.determineNextFloor(floorNum).getFloorNumber();

        if (nextStop > elevatorCurrState.getCurrentFloor())
            elevatorCurrState.setDirection(Direction.UP);
        else if (nextStop < elevatorCurrState.getCurrentFloor())
            elevatorCurrState.setDirection(Direction.DOWN);
        if (nextStop != elevatorCurrState.getCurrentFloor())
            elevatorCurrState.setStatus(Status.MOVING);

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public ElevatorController(int id, ElevatorCar elevatorCar) {
        this.id = id;
        this.elevatorCar = elevatorCar;
        this.controlStrategy=ElevatorSystem.getElevatorSystem().getElevatorControlStrategy();
        this.elevatorCurrState=new ElevatorCurrState();
    }


    public void setCurrFloor(int floorNum) {
        //Controller should check if this is stopping point
        //If yes, should stop using stop method
        elevatorCurrState.setCurrentFloor(floorNum);
    }
}
