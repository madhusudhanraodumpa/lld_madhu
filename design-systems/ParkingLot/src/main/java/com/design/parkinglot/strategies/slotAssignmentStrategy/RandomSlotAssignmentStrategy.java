package com.design.parkinglot.strategies.slotAssignmentStrategy;

import com.design.parkinglot.model.*;

import java.util.Optional;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{
    @Override
    public Optional<ParkingSlot> findSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) {

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloorList()) {
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlotList()) {
                if(parkingSlot.getSlotStatus().equals(SlotStatus.EMPTY) &&
                        parkingSlot.getVehicleTypeList().contains(vehicleType)) {
                    return Optional.of(parkingSlot);
                }
            }

        }
        return Optional.empty();
    }
}
