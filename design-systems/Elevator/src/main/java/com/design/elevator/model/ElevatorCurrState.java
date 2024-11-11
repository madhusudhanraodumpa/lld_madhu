package com.design.elevator.model;

public class ElevatorCurrState {
    private int currentFloor;
    private Direction direction;
    private Status status;

    public ElevatorCurrState() {
        this.currentFloor=0;
        this.direction=Direction.IDLE;
        this.status=Status.IDLE;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
