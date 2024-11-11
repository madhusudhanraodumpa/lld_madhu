package com.design.elevator.model;

public class Floor {
    private int floorNumber;
    private Button button;
    private Display display;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.button = new ExternalButton();
        this.display = new Display();

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    private void pressButton(Direction direction,int floorNumber) {
        this.button.pressButton(direction,floorNumber,-1);
    }
    private Display getDisplay(Direction direction,int currentFloor){
        this.display.setDirection(direction);
        this.display.setCurrentFloor(currentFloor);
        return this.display;
    }


}
