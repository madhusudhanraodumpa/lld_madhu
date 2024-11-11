package com.design.elevator.model;

public class InternalButton implements Button{
   private InternalRequestProcessor internalRequestProcessor;

    public InternalButton() {
        this.internalRequestProcessor = new InternalRequestProcessor();
    }

    @Override
    public void pressButton(Direction direction, int floorNumber, int elevatorNumber) {
        System.out.println("Pressed floor "+ floorNumber + " from elevator "+ elevatorNumber);
        ElevatorSystem.getElevatorSystem().sendInternalRequest(floorNumber,direction,elevatorNumber);
    }
}
