package com.design.elevator.stratgies;

import com.design.elevator.model.Direction;
import com.design.elevator.model.ExternalRequest;

public class OddEvenElevatorSelectionStrategy implements ElevatorSelectionStrategy{
    @Override
    public int selectElevator(ExternalRequest externalRequest) {
        // For demo purposes, return elevator id 1 if srcFloor is odd and 2 if it is even
        System.out.print("Selecting elevator according to odd-even strategy and returning elevator id ");
        if (externalRequest.getFloorNumber() % 2 == 0) {
            System.out.println(2);
            return 2;
        }
        System.out.println(1);
        return 1;
    }
}
