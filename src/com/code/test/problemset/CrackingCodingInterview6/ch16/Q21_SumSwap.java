package com.code.test.problemset.CrackingCodingInterview6.ch16;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Sum Swap:
 * Given two arrays of integers, find a pair of values (one value from each array) that you
 * can swap to give the two arrays the same sum.
 * EXAMPLE
 * lnput:{4, 1, 2, 1, 1, 2}and{3, 6, 3, 3}
 * Output: {1, 3}
 */
public class Q21_SumSwap {

    /**
     * Brute Force
     */
    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();

        for (int one : array1) {
            for (int two : array2) {
                int newSum1 = sum1 - one + two;
                int newSum2 = sum2 - two + one;
                if (newSum1 == newSum2) {
                    int[] values = {one, two};
                    return values;
                }
            }
        }

        return null;
    }

    //--------------------------------
    static class SoltutionOptimal {
        public static int[] findSwapValues(int[] array1, int[] array2) {
            int sum1 = Arrays.stream(array1).sum();
            int sum2 = Arrays.stream(array2).sum();

            if ((sum1 - sum2) % 2 != 0)
                return null;
            int target = (sum1 - sum2) / 2;
            return findDifference(array1, array2, target);
        }

        public static int[] findDifference(int[] array1, int[] array2, int target) {
            HashSet<Integer> contents2 = getContents(array2);
            for (int one : array1) {
                int two = one - target;
                if (contents2.contains(two)) {
                    int[] values = {one, two};
                    return values;
                }
            }

            return null;
        }

        public static HashSet<Integer> getContents(int[] array) {
            HashSet<Integer> set = new HashSet<>();
            for (int a : array) {
                set.add(a);
            }
            return set;
        }

        public static void main(String[] args) {
            int[] array1 = {-9, -1, -4, 8, 9, 6, -5, -7, 3, 9};
            int[] array2 = {6, 6, 4, -1, 7, -6, -9, 4, -8, 8};
            int[] swaps = findSwapValues(array1, array2);
            if (swaps == null) {
                System.out.println("null");
            } else {
                System.out.println(swaps[0] + " " + swaps[1]);
            }
        }
    }
}
