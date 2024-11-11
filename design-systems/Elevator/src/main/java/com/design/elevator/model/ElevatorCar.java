package com.design.elevator.model;

import com.design.elevator.controller.ElevatorController;

public class ElevatorCar {
    private int elevatorNumber;
    private Display display;
    private Button button;
    private int currentFloor;
    private Direction direction;
    private ElevatorController elevatorController;


    public ElevatorCar(int elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
        this.button = new InternalButton();
        this.currentFloor=0;
        this.direction = Direction.IDLE;
        this.display = new Display();
        this.elevatorController = new ElevatorController(elevatorNumber,this);
    }

    public void pressButton(int floor) {
        Direction direction= Direction.IDLE;
        if(floor>currentFloor)
            direction= Direction.UP;
        else if(floor<currentFloor)
            direction= Direction.DOWN;
        button.pressButton( direction, floor,elevatorNumber);
    }
    public void moveToFloor(int floorNum) {

        elevatorController.moveElevatorToFloor(floorNum);
    }
    public void notifyFloorNumUpdate(int floorNum) {
        elevatorController.setCurrFloor(floorNum);
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public void setElevatorNumber(int elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    public void setElevatorController(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }
}
