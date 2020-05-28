package com.code.test.problemset.companies.Pramp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Absolute Value Sort
 * Given an array of integers arr, write a function absSort(arr),
 * that sorts the array according to the absolute values of the numbers in arr.
 * If two numbers have the same absolute value, sort them according to sign, where the negative numbers come before the positive numbers.
 *
 * Examples:
 *
 * input:  arr = [2, -7, -2, -2, 0]
 * output: [0, -2, -2, 2, -7]
 * Constraints:
 *
 * [time limit] 5000ms
 * [input] array.integer arr
 * 0 ≤ arr.length ≤ 10
 * [output] array.integer
 */
public class AbsoluteValueSort {

    static int[] absSort(int[] input) {
        input = Arrays.stream(input).boxed().sorted((o1, o2) -> {
            Integer a = Integer.valueOf(o1.toString());
            Integer b = Integer.valueOf(o2.toString());

            if(Math.abs(a) != Math.abs(b)){
                return Math.abs(a) - Math.abs(b);
            }else{
                return a.compareTo(b);
            }
        }).mapToInt(Integer::intValue).toArray();

        return input;
    }


    public static void main(String[] args) {
            absSort(new int[]{2, -7, -2, -2, 0});
    }
}
