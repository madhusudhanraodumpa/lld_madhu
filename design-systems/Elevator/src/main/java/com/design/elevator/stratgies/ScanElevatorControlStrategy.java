package com.design.elevator.stratgies;

import com.design.elevator.model.Floor;

public class ScanElevatorControlStrategy extends ElevatorControlStrategy{
    @Override
    public Floor determineNextFloor(int floorNumber) {
        return new Floor(1);
    }
}
