package com.design.parkinglot.repositories;

import com.design.parkinglot.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Long lastVehicleId=0L;
    Map<Long,Vehicle> vehicleMap = new HashMap<>();
    public Optional<Vehicle> findVehicleByNumber(Long vehicleNumber) {
        if(vehicleMap.containsKey(vehicleNumber)) {
            return Optional.of(vehicleMap.get(vehicleNumber));
        }

        return Optional.empty();
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        vehicle.setId(lastVehicleId+1);
        lastVehicleId = lastVehicleId+1;
        vehicleMap.put(lastVehicleId,vehicle);
        return vehicle;
    }
}
