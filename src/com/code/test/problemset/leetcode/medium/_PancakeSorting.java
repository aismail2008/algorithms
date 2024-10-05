package com.code.test.problemset.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Pancake Sorting
 * Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
 * Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * A[i] is a permutation of [1, 2, ..., A.length]
 * <p>
 * https://leetcode.com/problems/pancake-sorting/
 *
 *   // Space Complexity : O(1)
 *   // Time Complexity : O(n2)
 */
public class _PancakeSorting {

    /*
     for i: 0 -> n
      find max if in right position then skip to next max
      swap it with 0 -> index of max
      swap from 0 to it's right index
     */
    public List<Integer> pancakeSort(int[] a) {
        List<Integer> output = new ArrayList<>();
        int max = a.length;
        // find max if in right position then skip to next max
        while (max > 2) {
            int i = 0;
            for (; i <= max; i++) {
                if (a[i] == max)
                    break;
            }
            if (i != max - 1) {
                //swap it with 0 -> index of max
                swap(a, 0, i); // putting max at position 0
                output.add(i + 1);
                swap(a, 0, max - 1); // putting max at position max
                output.add(max);
            }
            max--;
        }
        if (a[0] == 2 && a[1] == 1) {
            a[0] = 1;
            a[1] = 2;
            // here k = 2
            output.add(2);
        }

        return output;
    }

    static void swap(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}
