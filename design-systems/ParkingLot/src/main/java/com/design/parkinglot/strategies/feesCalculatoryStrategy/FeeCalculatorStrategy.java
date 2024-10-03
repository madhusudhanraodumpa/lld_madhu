package com.design.parkinglot.strategies.feesCalculatoryStrategy;

import com.design.parkinglot.model.VehicleType;

import java.util.Date;

public interface FeeCalculatorStrategy {


        public int calculateFees(VehicleType vehicleType, Date entryTime,Date exitTime);

}
