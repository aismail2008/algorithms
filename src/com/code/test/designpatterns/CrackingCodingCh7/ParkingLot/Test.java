package com.code.test.designpatterns.CrackingCodingCh7.ParkingLot;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by aliismail on 30/11/2017.
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle v = null;
        while (v == null || lot.parkVehicle(v)) {
            lot.print();
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
