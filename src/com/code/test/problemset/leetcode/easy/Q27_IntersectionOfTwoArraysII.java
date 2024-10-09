package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
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
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
@Easy
public class Q27_IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i : nums1) {
            set.put(i, set.getOrDefault(i, 0) + 1);
        }

        List<Integer> intersectionList = new ArrayList<>();
        for (int i : nums2) {
            if (set.containsKey(i) && set.get(i) > 0) {
                intersectionList.add(i);
                set.put(i, set.get(i) - 1);
            }
        }

        int[] result = new int[intersectionList.size()];
        int i = 0;
        for (int n : intersectionList) {
            result[i++] = n;
        }
        return result;
    }
}
