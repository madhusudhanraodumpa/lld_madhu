package com.design.elevator.model;

import com.design.elevator.controller.ElevatorController;
import com.design.elevator.stratgies.ElevatorSelectionStrategy;
import com.design.elevator.stratgies.OddEvenElevatorSelectionStrategy;

public class ExternalRequestProcessor {
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ExternalRequestProcessor() {
        // Setting default elevator selection strategy
        elevatorSelectionStrategy = new OddEvenElevatorSelectionStrategy();
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public void processExternalRequest(ExternalRequest externalRequest) {

        int elevatorId = elevatorSelectionStrategy.selectElevator(externalRequest);
        System.out.println("Selected elevator " + elevatorId);
        ElevatorCar elevatorCar = ElevatorCarManager.getElevatorCarManager().getElevatorCar(elevatorId);
        elevatorCar.moveToFloor(externalRequest.getFloorNumber());





    }
}
