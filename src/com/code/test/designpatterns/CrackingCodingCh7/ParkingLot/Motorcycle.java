package com.code.test.designpatterns.CrackingCodingCh7.ParkingLot;

/**
 * Created by aliismail on 30/11/2017.
 */
public class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    public void print() {
        System.out.print("M");
    }
}
