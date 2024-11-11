package com.design.elevator.stratgies;

import com.design.elevator.model.Floor;
import com.design.elevator.model.PendingRequest;

import java.util.LinkedList;
import java.util.Queue;

public abstract class ElevatorControlStrategy {
    public Queue<PendingRequest> pendingRequestList= new LinkedList<>();

    public abstract Floor determineNextFloor(int floorNumber);

    public Queue<PendingRequest> getPendingRequestList() {
        return pendingRequestList;
    }
}
