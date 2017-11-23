package com.code.test.problemset.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by aliismail on 22/11/2017.
 */
public class AmazonChallenge3 {

    public static void main(String[] args) {
        int[] res = getMinimumDifference(new String[]{"xulkowreuowzxgnhmiqekxhz", "jk", "abb", "mn", "abc"}, new String[]{"istdocbnyozmnqthhpievvlj", "kj", "bbc", "op", "def"});
    }

    /**
     * Get the Minimum number of changes to apply for two string a,b to be anagram
     * @param a
     * @param b
     * @return
     */

    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] res = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                res[i] = -1;
            } else {
                int[] charArr = new int[26];
                for (int j = 0; j < a[i].length(); j++) {
                    charArr[a[i].charAt(j) - 'a']++;
                }
                int diff = 0;
                for (int j = 0; j < b[i].length(); j++) {
                    if (charArr[b[i].charAt(j) - 'a'] > 0) {
                        charArr[b[i].charAt(j) - 'a']--;
                    } else {
                        diff++;
                    }
                }
                res[i] = diff;
            }
        }
        return res;
    }

    /**
     * Amy has an array, nums, of n positive integers and another array, maxes, of m positive integers.
     * For each maxes(i) in maxes, she wants to know the total number of elements in nums which are less or equal to that maxes(i).
     * For example, if nums =[1,2,3] and maxes= [2,4], then there are 2 elements in nums that are <= maxes(0) (which is 2)
     * and 3 elements in nums that are <= maxes(1) (which is 4).
     * We can store these respective another answers in another array, answer=[2,3].
     * Complete the counts function in the editor below, it has two parameters:
     *      1. An array, nums, of n positive integers.
     *      2 An array, maxes, of m positive integers.
     * The function must return an array of m positive integers in which the integer at each index i(where 0 <= i < m)
     * denotes the total number of elements mums(j) (where 0 <=i < n) satisfying nums(j) <= maxes(i).
     * Input Format:
     *  The Locked stub code in the editor reads the input from stdin and passes to the function that you must implement that takes in the parameter arrays nums and maxes.
     *  Constraints:
     *      2 <= n, m <= 10^5
     *      1 <= nums(j) <= 10^9, where 0 <= j < n
     *      1 <= maxes(i) <= 10^9, where 0 <= i< m.
     * Output Format:
     *  The function must return an array of m integers where the value stored at each indexi (where osiem)denotes the total number of elements nums ere o si<n) satisfying mums s mases This is printed to dour by locked stub code in the editor.
     * Sample input:
     * nums: [1,4,2,4]
     * maxes: [3,5]
     * Sample output:
     *  [2.4]
     */

    static int[] counts(int[] nums, int[] maxes) {
        //    nums array = N
        //    maxes array = M
        //    Sorting takes O(NlogN) used quicksort
        //    and iterate through maxes array takes O(M) and in each iteration
        //we do an upper bound binary search which takes O(logN)
        //        so overall Time Complexity is O(NlogN) + O(MlogN)
        //        and space complexity is O(N), which is used to store output data
        if (nums == null || nums.length == 0)
            return new int[0];
        if (maxes == null || maxes.length == 0)
            return new int[0];
        int[] res = new int[maxes.length];
        Arrays.sort(nums);

        for (int i = 0; i < maxes.length; i++) {
            int index = searchUpperBound(nums, maxes[i]);
            if (index > 0) {
                res[i] = index + 1;
            } else {
                res[i] = Math.abs(index);
            }
        }
        return res;
    }

    static int searchUpperBound(int[] a, int key) {
        if (key < a[0])
            return 0;
        if (key > a[a.length - 1]) return a.length - 1;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key && (mid == a.length - 1 || a[mid + 1] != key))
                return mid; // key found

            if (a[mid] <= key)
                lo = mid + 1; // pay attention
            else
                hi = mid - 1;
        }

        return -(hi + 1); // key not found, position to be inserted is returned
    }
}
