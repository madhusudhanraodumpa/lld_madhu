package com.design.parkinglot.repositories;

import com.design.parkinglot.model.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    Map<Long,Gate> gateMap = new HashMap<>();
    public Optional<Gate> findGateById(Long Id) {

        if (gateMap.containsKey(Id)) {
            return Optional.of(gateMap.get(Id));
        }
        return Optional.empty();
    }
}
