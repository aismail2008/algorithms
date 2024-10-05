package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
@Easy
public class Q1_RemoveDuplicateSortedArray {
    public static int removeDuplicated(int[] a) {
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[j])
                a[++j] = a[i];
        }
        return j + 1;
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 3, 3, 4, 5, 5, 6};
        removeDuplicated(a);
    }

}
