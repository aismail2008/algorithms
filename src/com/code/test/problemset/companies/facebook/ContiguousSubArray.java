package com.code.test.problemset.companies.facebook;

import java.util.Stack;

/**
 * Contiguous Subarrays
 * You are given an array a of N integers.
 * For each index i, you are required to determine the number of contiguous subarrays that fulfills the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 * Signature
 * int[] countSubarrays(int[] arr)
 * Input
 * Array a is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of a[i]
 * Example:
 * a = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * Explanation:
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 -[1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 */
public class ContiguousSubArray {
    // O(N2)
    static int[] countSubarrays(int[] arr) {
        int[] total = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //max before;
            int bef = i;
            while (bef > 0 && arr[bef - 1] < arr[i]) {
                bef--;
            }
            total[i] += Math.abs(i - bef);

            bef = i;
            while (bef + 1 < arr.length && arr[i] > arr[bef + 1]) {
                bef++;
            }
            total[i] += Math.abs(i - bef);
            total[i]++;
        }
        return total;
    }

    public static void main(String[] args) {
        countSubarrays(new int[]{3, 4, 1, 6, 2});
        new SolutionOptimized().countSubarrays(new int[]{3, 4, 1, 6, 2});
    }

    static class SolutionOptimized {
        int[] countSubarrays(int[] arr) {

            int[] left = BuildLeft(arr);
            int[] right = BuildRight(arr);

            int[] result = new int[arr.length];

            for (int i = 0; i < arr.length; ++i) {
                result[i] = left[i] + right[i] + 1; //max left + max right + current element
            }

            return result;
        }

        int[] BuildLeft(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            int[] left = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    //Size of largest subarray to the left of popped element + the popped element itself
                    left[i] += left[stack.pop()] + 1;
                }
                stack.push(i);
            }
            return left;
        }

        int[] BuildRight(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            int[] right = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    right[i] += right[stack.pop()] + 1;
                }
                stack.push(i);
            }
            return right;
        }
    }
}
