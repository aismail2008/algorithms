package com.code.test.problemset.programcreekbook;

import java.util.Arrays;

/**
 * Created by aliismail on 06/12/2017.
 */
public class PrimeNumberGenerator {

    public static void main(String[] agrs){
        sieveOfEratosthenes(120);
    }

    static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        int count = 0;
        Arrays.fill(flags, true);
//        init(flags); // Set all flags to true other than 0 and 1
        int prime = 2;
        while (prime <= Math.sqrt(max)) {
          /* Cross off remaining multiples of prime */
            crossOff(flags, prime);

           /* Find next value which is true */
            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    static void crossOff(boolean[] flags, int prime) {
         /*
          * Cross off remaining multiples of prime. We can start with (prime*prime),
          * because if we have a k * prime, where k < prime, this value would have
          * already been crossed off in a prior iteration.
          */
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }
}
