package com.code.test.problemset.leetcode.medium;


import com.code.test.problemset.leetcode.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Largest Time for Given Digits
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * Example 1:
 * Input: [1,2,3,4]
 * Output: "23:41"
 * <p>
 * Example 2:
 * Input: [5,5,5,5]
 * Output: ""
 * <p>
 * Note:
 * A.length == 4
 * 0 <= A[i] <= 9
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
@Medium
public class _LargestTimeFromDigits {

    static class Solution {

        public static void main(String[] args) {
            System.out.println(largestTimeFromDigits_better(new int[]{2, 0, 6, 6}));
            System.out.println(largestTimeFromDigits_better(new int[]{1, 2, 3, 4}));
            System.out.println(largestTimeFromDigits_better(new int[]{5, 5, 5, 5}));
        }

        public static String largestTimeFromDigits_better(int[] arr) {
            Arrays.sort(arr);
            for (int i = 3; i >= 0; i--) {
                for (int j = 3; j >= 0; j--) {
                    if (j == i)
                        continue;
                    for (int k = 3; k >= 0; k--) {
                        if (k == i || k == j)
                            continue;
                        int l = 6 - i - j - k;

                        int hours = arr[i] * 10 + arr[j];
                        int mins = arr[k] * 10 + arr[l];

                        if (hours < 24 && mins < 60) {
                            return String.format("%02d:%02d", hours, mins);
                        }
                    }
                }
            }
            return "";
        }

        public static String largestTimeFromDigits_1(int[] arr) {
            Arrays.stream(arr).sorted();
            int found2 = getIndex(arr, 2);
            String sol = "";
            if(found2 != -1) {
                arr[found2] = -1;
                sol  = "2";
                int index = getMax(arr, 3);
                if(index == -1)
                    return "";
                sol += arr[index]+":";
                arr[index] = -1;

                index = getMax(arr, 5);
                if(index == -1)
                    return "";
                sol += arr[index];
                arr[index] = -1;

                index = getMax(arr, 9);
                if(index == -1)
                    return "";
                sol += arr[index];
                arr[index] = -1;
                return  sol;
            }else{
                int zeroOne = getIndex(arr, 1);
                if(zeroOne == -1){
                    zeroOne = getIndex(arr, 0);
                    if(zeroOne == -1)
                        return "";
                }

                sol  = "" + arr[zeroOne];
                int index = getMax(arr, 9);
                if(index == -1)
                    return "";
                sol += arr[index]+":";
                arr[index] = -1;

                index = getMax(arr, 5);
                if(index == -1)
                    return "";
                sol += arr[index];
                arr[index] = -1;

                index = getMax(arr, 9);
                if(index == -1)
                    return "";
                sol += arr[index];
                arr[index] = -1;
                return  sol;
            }
        }

        public static int getMax(int[] arr, int max) {
            for (int i = 3; i >= 0; i--) {
                if(0 <= arr[i] && arr[i] <= max)
                    return i;
            }
            return  -1;
        }
        // Function to return the index of a value
        public static int getIndex(int[] arr, int value) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    return i;  // Return the index if the value is found
                }
            }
            return -1;  // Return -1 if the value is not found
        }


        public static String largestTimeFromDigits_2(int[] num) {
            permutationsList = new TreeSet<>(Comparator.reverseOrder());
            permutations("" + num[0] + num[1] + num[2] + num[3], "");
            if (permutationsList.size() == 0)
                return "";
            String s = permutationsList.iterator().next();
            return s.substring(0, 1) + s.substring(1, 2) + ":" + s.substring(2, 3) + s.substring(3, 4);

        }

        static Set<String> permutationsList = new TreeSet<>(Comparator.reverseOrder());

        public static void permutations(String s, String prefix) {
            if (s.length() == 0) {
                //check and add only valid time
                if (prefix.substring(0, 1).equals("2")) {
                    if (Integer.valueOf(prefix.substring(1, 2)) <= 3) {
                        if (Integer.valueOf(prefix.substring(2, 3)) <= 5) {
                            permutationsList.add(prefix);
                        }
                    }
                }
                if (Integer.valueOf(prefix.substring(0, 1)) <= 1) {
                    if (Integer.valueOf(prefix.substring(2, 3)) <= 5) {
                        permutationsList.add(prefix);
                    }
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    String rem = s.substring(0, i) + s.substring(i + 1);
                    permutations(rem, prefix + s.charAt(i));
                }
            }
        }
    }
}
