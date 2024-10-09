package com.code.test.problemset.companies.Pramp;

import com.code.test.problemset.leetcode.medium.Q31_4Sum;

import java.util.Arrays;

/**
 * Array Quadruplet
 * Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.
 *
 * Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you encounter (considering the results are sorted).
 *
 * Explain and code the most efficient solution possible, and analyze its time and space complexities.
 *
 * Example:
 *
 * input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
 *
 * output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
 *                      # whose sum is 20. Notice that there
 *                      # are two other quadruplets whose sum is 20:
 *                      # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
 *                      # asked to return the just one quadruplet (in an
 *                      # ascending order)
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.integer arr
 *
 * 1 ≤ arr.length ≤ 100
 * [input] integer s
 *
 * [output] array.integer
 *
 * Time Complexity: we have three nested loops whose combined time complexity is O(N^3), where N is the size of arr.
 * Space Complexity: O(1) as we used only a constant amount of space throughout the algorithm.
 */
public class ArrayQuadruplet {
    public static void main(String[] args) {
        new Q31_4Sum();
    }

    static int[] findArrayQuadruplet(int[] arr, int s) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int h = j + 1;
                int k = arr.length - 1;
                while (h < k) {
                    if (arr[i] + arr[j] + arr[h] + arr[k] == s) {
                        return new int[]{arr[i], arr[j], arr[h], arr[k]};
                    } else if (arr[i] + arr[j] + arr[h] + arr[k] < s) {
                        h++;
                        while (h + 1 < arr.length && arr[h] == arr[h + 1])
                            h++;
                    } else {
                        k--;
                        while (k - 1 > h && arr[k] == arr[k - 1])
                            k--;
                    }
                }
            }
        }
        return new int[]{};
    }
}
