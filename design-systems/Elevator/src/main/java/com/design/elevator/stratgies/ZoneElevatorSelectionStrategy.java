package com.design.elevator.stratgies;

import com.design.elevator.model.Direction;
import com.design.elevator.model.ExternalRequest;

public class ZoneElevatorSelectionStrategy implements ElevatorSelectionStrategy{
    @Override
    public int selectElevator(ExternalRequest externalRequestn) {
        // For demo purposes, always returning elevator id 3
        System.out.println("Selecting elevator according to zone strategy and returning elevator id 3");
        return 3;
    }
}
