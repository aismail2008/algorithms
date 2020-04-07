package com.code.test.problemset.CrackingCodingInterview6.ch7.Q4_ParkingLot;

/**
 * Created by aliismail on 30/11/2017.
 */
public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }

    public void print() {
        System.out.print("B");
    }
}
