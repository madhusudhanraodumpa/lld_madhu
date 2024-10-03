package com.design.parkinglot.repositories;

import com.design.parkinglot.model.Gate;
import com.design.parkinglot.model.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {

    Map<Long,ParkingLot> parkingLotMap = new HashMap<>();
    public Optional<ParkingLot> getParkingLotOfGate(Gate gate) {
        for (ParkingLot parkingLot: parkingLotMap.values()) {
            if (parkingLot.getGateList().contains(gate)) {
                return Optional.of(parkingLot);
            }
        }

        return Optional.empty();
    }
}
