package com.code.test.problemset.companies.Pramp;

import com.code.test.problemset.leetcode.Q87_SlidingWindowMaximum;

import java.util.PriorityQueue;

/**
 * K-Messed Array Sort
 * Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr.
 * For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
 *
 * Analyze the time and space complexities of your solution.
 *
 * Example:
 *
 * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
 *
 * output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.integer arr
 *
 * 1 ≤ arr.length ≤ 100
 * [input] integer k
 *
 * 0 ≤ k ≤ 20
 * [output] array.integer
 */
public class KMissedArraySort {


    public static void main(String[] args) {
        // Similar to max window size
        new Q87_SlidingWindowMaximum();
    }

    static int[] sortKMessedArray(int[] arr, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i = 0;
        for(;i < k && i < arr.length; i++){
            q.offer(arr[i]);
        }

        int h = 0;
        while(!q.isEmpty()){ //
            arr[h++] = q.poll(); // n * log k
            if(i < arr.length)
                q.offer(arr[i++]);
        }

        return arr;
    }
}
