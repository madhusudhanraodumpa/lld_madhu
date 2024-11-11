package com.design.elevator.model;

public class ExternalButton implements Button{

    private ExternalRequestProcessor externalRequestProcessor;

    public ExternalButton() {
        this.externalRequestProcessor = new ExternalRequestProcessor();
    }

    @Override
    public void pressButton(Direction direction, int floorNumber, int elevatorNumber) {
        ExternalRequest externalRequest= new ExternalRequest(floorNumber,direction);
        ElevatorSystem.getElevatorSystem().sendExternalRequest(floorNumber,direction);

    }
}
