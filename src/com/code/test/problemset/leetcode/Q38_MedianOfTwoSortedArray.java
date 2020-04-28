package com.code.test.problemset.leetcode;

/**
 * Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
@Hard
public class Q38_MedianOfTwoSortedArray {

    static class SolutionHard {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            if (total % 2 == 0) {
                return (getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2)
                        + getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 - 1)) / 2.0;
            } else {
                return getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2);
            }
        }

        //k is the index starting from 0
        private int getKth(int[] nums1, int i1, int j1, int[] nums2, int i2, int j2, int k) {
            if (j1 < i1) {
                return nums2[i2 + k];
            }
            if (j2 < i2) {
                return nums1[i1 + k];
            }

            if (k == 0) {
                return Math.min(nums1[i1], nums2[i2]);
            }

            int len1 = j1 - i1 + 1;
            int len2 = j2 - i2 + 1;

            int m1 = k * len1 / (len1 + len2);
            int m2 = k - m1 - 1;

            m1 += i1;
            m2 += i2;

            if (nums1[m1] < nums2[m2]) {
                k = k - (m1 - i1 + 1);
                j2 = m2;
                i1 = m1 + 1;
            } else {
                k = k - (m2 - i2 + 1);
                j1 = m1;
                i2 = m2 + 1;
            }

            return getKth(nums1, i1, j1, nums2, i2, j2, k);
        }
    }
}
