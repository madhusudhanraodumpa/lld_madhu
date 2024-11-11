package com.design.elevator.model;

import com.design.elevator.controller.ElevatorController;

public class InternalRequestProcessor {
    public void processInternalRequest(InternalRequest internalRequest) {
        int elevatorId= internalRequest.getElevatorNumber();
        System.out.println("Pressed floor "+ internalRequest.getFloorNumber() + " from elevator "+ elevatorId);
        ElevatorCar elevatorCar = ElevatorCarManager.getElevatorCarManager().getElevatorCar(elevatorId);
        elevatorCar.moveToFloor(internalRequest.getFloorNumber());
    }
}
