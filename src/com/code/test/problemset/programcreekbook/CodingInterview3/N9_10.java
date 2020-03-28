package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by aliismail on 10/11/2017.
 */
public class N9_10 {
//    Problem:
//    Given an array of integers, find two numbers such that they add up to a specific
//    target number.
//    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//    Please note that your returned answers (both index1 and index2) are not zero-based.
//    For example:
//    Input: numbers={2, 7, 11, 15}, target=9
//    Output: index1=1, index2=2

    public static void main(String[] args) {
        twoSum(new int[] { 2, 7, 11, 15 }, 9);
    }

    // -------- Array is not sorted
    /// 1 � 2Sum
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        Arrays.stream(result).forEach(System.out::println);
        return result;
    }

    /// 2 � 2Sum Sorted
    public static int[] twoSumSorted(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i, j };
            }
        }
        return null;
    }
}

