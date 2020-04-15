package com.code.test.problemset.leetcode;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class _Mockup5 {

    /**
     *
     * Largest Time for Given Digits
     * Given an array of 4 digits, return the largest 24 hour time that can be made.
     * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
     * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
     * Example 1:
     * Input: [1,2,3,4]
     * Output: "23:41"
     *
     *  Example 2:
     * Input: [5,5,5,5]
     * Output: ""
     *
     * Note:
     * A.length == 4
     * 0 <= A[i] <= 9
     */
    static class Solution {

        public static void main(String[] args) {
            System.out.println(largestTimeFromDigits(new int[]{2,0,6,6}));
            System.out.println(largestTimeFromDigits(new int[]{1,2,3,4}));
            System.out.println(largestTimeFromDigits(new int[]{5,5,5,5}));
        }

        public static String largestTimeFromDigits(int[] num) {
            permutationsList = new TreeSet<>(Comparator.reverseOrder());
            permutations("" + num[0] + num[1] + num[2] + num[3], "");
            if(permutationsList.size() == 0)
                return "";
            String s = permutationsList.iterator().next();
            return s.substring(0,1) + s.substring(1,2) + ":" + s.substring(2,3) + s.substring(3,4);

        }

        static Set<String> permutationsList = new TreeSet<>(Comparator.reverseOrder());

        public static void permutations(String s, String prefix) {
            if (s.length() == 0) {
                if(prefix.substring(0,1).equals("2")){
                    if(Integer.valueOf(prefix.substring(1,2)) <= 3){
                        if(Integer.valueOf(prefix.substring(2,3)) <= 5){
                            permutationsList.add(prefix);
                        }
                    }
                } if(Integer.valueOf(prefix.substring(0,1)) <= 1){
                    if(Integer.valueOf(prefix.substring(2,3)) <= 5){
                        permutationsList.add(prefix);
                    }
                }
                return;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    String rem = s.substring(0, i) + s.substring(i + 1);
                    permutations(rem, prefix + s.charAt(i));
                }
            }
        }
    }

    static class Solution2{
        Q201_RangeSumQuery q201_rangeSumQuery = new Q201_RangeSumQuery();
    }
}
