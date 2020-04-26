package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Q27_IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> set1 = new HashMap<>();
        for (int i : nums1) {
            set1.put(i, set1.getOrDefault(i, 0) + 1);
        }

        List<Integer> set2 = new ArrayList<>();
        for (int i : nums2) {
            if (set1.containsKey(i) && set1.get(i) > 0) {
                set2.add(i);
                set1.put(i, set1.get(i) - 1);
            }
        }

        int[] result = new int[set2.size()];
        int i = 0;
        for (int n : set2) {
            result[i++] = n;
        }
        return result;
    }
}
