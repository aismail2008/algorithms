package com.code.test.problemset.CrackingCodingInterview6.ch7.Q4_ParkingLot;

import java.util.Random;

/**
 * Parking Lot:
 *  Design a parking lot using object-oriented principles.
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle v = null;
        while (v == null || lot.parkVehicle(v)) {
            lot.print() ;
            int r = new Random().nextInt() * 10;
            if (r < 2) {
                v = new Bus();
            } else if (r < 4) {
                v = new Motorcycle();
            } else {
                v = new Car();
            }
            System.out.print("\nParking a ");
            v.print();
            System.out.println("");
        }
        System.out.println("Parking Failed. Final state: ");
        lot.print();
    }

}
