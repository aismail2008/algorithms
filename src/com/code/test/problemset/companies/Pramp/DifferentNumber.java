package com.code.test.problemset.companies.Pramp;

import java.util.*;

/**
 * Getting a Different Number
 * Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.
 * <p>
 * Even if your programming language of choice doesn’t have that restriction (like Python), assume that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance, the operation MAX_INT + 1 would be undefined in our case.
 * <p>
 * Your algorithm should be efficient, both from a time and a space complexity perspectives.
 * <p>
 * Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time, see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed. Do so without trading off the time complexity.
 * <p>
 * Analyze the time and space complexities of your algorithm.
 * <p>
 * Example:
 * <p>
 * input:  arr = [0, 1, 2, 3]
 * <p>
 * output: 4
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 1 ≤ arr.length ≤ MAX_INT
 * 0 ≤ arr[i] ≤ MAX_INT for every i, 0 ≤ i < MAX_INT
 * [output] integer
 */
public class DifferentNumber {
    static int getDifferentNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int t; //1
            while (arr[i] != i) {
                if (arr[i] > arr.length - 1) {
                    break;
                }
                t = arr[i]; // 3
                arr[i] = arr[t]; // = 1
                arr[t] = t;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i])
                return i;
        }
        // 1 0 3 4 5
        // 0 1 5 3 4

        //0, 1, 2
        return arr.length;

    }

    public static void main(String[] args) {

        int z = -0;
        System.out.println(z);

    }
}