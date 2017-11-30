package com.code.test.designpatterns.CrackingCodingCh7.ParkingLot;

/**
 * Created by aliismail on 30/11/2017.
 */
public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }

    public void print() {
        System.out.print("C");
    }
}
