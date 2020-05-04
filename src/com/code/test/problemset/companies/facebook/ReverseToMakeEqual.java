package com.code.test.problemset.companies.facebook;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Reverse to Make Equal
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
 * Signature
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if B can be made equal to A, return false otherwise.
 * Example
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 */
public class ReverseToMakeEqual {

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length) {
            return false;
        }

        Arrays.sort(array_a);
        Arrays.sort(array_b);
        for (int i = 0; i < array_a.length; i++) {
            if (array_a[i] != array_b[i])
                return false;
        }

        return true;

    }

    boolean areTheyEqual2(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array_a.length; i++) {
            if (!map.containsKey(array_a[i])) {
                map.put(array_a[i], 1);
            } else {
                map.put(array_a[i], map.get(array_a[i]) + 1);
            }
        }

        for (int i = 0; i < array_b.length; i++) {
            if (!map.containsKey(array_b[i]) || map.get(array_b[i]) < 1) {
                return false;
            } else {
                map.put(array_b[i], map.get(array_b[i]) - 1);
            }
        }

        return true;
    }


}
