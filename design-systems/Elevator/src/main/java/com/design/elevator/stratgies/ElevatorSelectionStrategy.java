package com.design.elevator.stratgies;

import com.design.elevator.model.Direction;
import com.design.elevator.model.ExternalRequest;

public interface ElevatorSelectionStrategy {
    public int selectElevator(ExternalRequest externalRequest);
}
