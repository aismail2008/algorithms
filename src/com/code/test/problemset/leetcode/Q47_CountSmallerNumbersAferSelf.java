package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Count of Smaller Numbers After Self
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class Q47_CountSmallerNumbersAferSelf {
    public static void main(String[] args) {
        new Q47_CountSmallerNumbersAferSelf().countSmaller(new int[]{5, 2, 6, 1});
        new Q47_CountSmallerNumbersAferSelf().countSmaller(new int[]{3, 7, 5, 2, 6, 1});
    }

    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        int[] output = new int[nums.length];
        Node root = new Node(nums[nums.length - 1]);
        output[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = insert(root, nums[i], 0);
        }
        return Arrays.stream(output).boxed().collect(Collectors.toList());
    }

    int insert(Node root, int k, int left) {
        if (k > root.key) {
            left += root.leftSize + 1;
            if (root.right == null) {
                root.right = new Node(k);
                return left;
            } else {
                return insert(root.right, k, left);
            }
        } else {
            root.leftSize++;
            if (root.left == null) {
                root.left = new Node(k);
                return left;
            } else {
                return insert(root.left, k, left);
            }
        }
    }

    static class Node {
        int key;
        int leftSize;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
}
