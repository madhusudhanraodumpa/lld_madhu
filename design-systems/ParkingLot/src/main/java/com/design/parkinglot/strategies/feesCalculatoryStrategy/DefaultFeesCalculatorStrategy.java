package com.design.parkinglot.strategies.feesCalculatoryStrategy;

import com.design.parkinglot.model.VehicleType;

import java.util.Date;

public class DefaultFeesCalculatorStrategy implements FeeCalculatorStrategy{
    @Override
    public int calculateFees(VehicleType vehicleType, Date entryTime, Date exitTime) {

        int totalHours = entryTime.getHours()-exitTime.getHours();
        if(vehicleType==VehicleType.BIKE) {
            if(totalHours<2) {
                return 10;
            } else if (totalHours<3) {
                return 15;
            }else {
                return totalHours*9;
            }
        }


        return 0;
    }
}
