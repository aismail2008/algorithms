package com.code.test.problemset.leetcode;

import java.util.Stack;

/**
 * Max Chunks To Make Sorted
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 * Example 1:
 *
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note:
 *
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class Q211_MaxChunksToMakeSorted {
    public static void main(String[] args) {
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{2, 0, 1}));
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1}));
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1, 2}));
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{3, 2}));
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    }

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // use [min,max] for each chunk
        Stack<int[]> stack = new Stack<int[]>();

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int max = arr[i];

            while (!stack.isEmpty()) {
                int[] top = stack.peek();

                if (arr[i] < top[1]) {
                    min = Math.min(top[0], min);
                    max = Math.max(max, top[1]);
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(new int[]{min, max});
        }

        return stack.size();
    }
}
