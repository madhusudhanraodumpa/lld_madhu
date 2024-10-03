package com.design.parkinglot.strategies.slotAssignmentStrategy;

import com.design.parkinglot.model.Gate;
import com.design.parkinglot.model.ParkingLot;
import com.design.parkinglot.model.ParkingSlot;
import com.design.parkinglot.model.VehicleType;

import java.util.Optional;

public interface SlotAssignmentStrategy {
    public Optional<ParkingSlot> findSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
