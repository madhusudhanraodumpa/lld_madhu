package com.design.elevator.model;

public class InternalRequest {
    private int floorNumber;
    private Direction direction;
    private int elevatorNumber;

    public InternalRequest(int floorNumber, Direction direction, int elevatorNumber) {
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.elevatorNumber = elevatorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public void setElevatorNumber(int elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
    }
}
