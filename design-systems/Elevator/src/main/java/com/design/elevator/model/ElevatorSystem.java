package com.design.elevator.model;

import com.design.elevator.controller.ElevatorController;
import com.design.elevator.stratgies.ElevatorControlStrategy;
import com.design.elevator.stratgies.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

    private InternalRequestProcessor internalRequestProcessor;
    private ExternalRequestProcessor externalRequestProcessor;
    private List<ElevatorCar> elevatorCars;
    private int numberOfFloor;
    private int numberOfElevators;
    private List<Floor> floors;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;
    private ElevatorControlStrategy elevatorControlStrategy;
    private ElevatorCarManager elevatorCarManager;
    public static ElevatorSystem INSTANCE;

    private ElevatorSystem() {}
    public void initializeElevatorSystem(int numberOfFloor, int numberOfElevators, ElevatorSelectionStrategy elevatorSelectionStrategy,ElevatorControlStrategy elevatorControlStrategy) {
        this.numberOfFloor = numberOfFloor;
        this.numberOfElevators = numberOfElevators;
        this.elevatorControlStrategy = elevatorControlStrategy;
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
        this.externalRequestProcessor= new ExternalRequestProcessor();
        this.internalRequestProcessor = new InternalRequestProcessor();
        this.externalRequestProcessor.setElevatorSelectionStrategy(this.elevatorSelectionStrategy);
        this.elevatorCarManager.getElevatorCarManager().initializeElevatorCarAndController(numberOfElevators);
    }


    public static  ElevatorSystem getElevatorSystem() {
        if(INSTANCE==null){
            INSTANCE = new ElevatorSystem();
        }
        return INSTANCE;
    }

    public void sendExternalRequest(int floorNumber,Direction direction) {
        this.externalRequestProcessor.processExternalRequest(new ExternalRequest(floorNumber,direction));

    }
    public void sendInternalRequest(int floorNumber,Direction direction,int elevatorId) {
        InternalRequest internalRequest = new InternalRequest(floorNumber,direction,elevatorId);
        this.internalRequestProcessor.processInternalRequest(internalRequest);


    }



    public List<ElevatorCar> getElevatorCars() {
        return elevatorCars;
    }

    public void setElevatorCars(List<ElevatorCar> elevatorCars) {
        this.elevatorCars = elevatorCars;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getNumberOfElevators() {
        return numberOfElevators;
    }

    public void setNumberOfElevators(int numberOfElevators) {
        this.numberOfElevators = numberOfElevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public ElevatorSelectionStrategy getElevatorSelectionStrategy() {
        return elevatorSelectionStrategy;
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }

    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy) {
        this.elevatorControlStrategy = elevatorControlStrategy;
    }

    public ElevatorCarManager getElevatorCarManager() {
        return elevatorCarManager;
    }

    public void setElevatorCarManager(ElevatorCarManager elevatorCarManager) {
        this.elevatorCarManager = elevatorCarManager;
    }


}
