package com.code.test.problemset.leetcode;

/**
 * Max Chunks To Make Sorted
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number
 * of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
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
 * However, splitting into [1, 0], [2]
 *, [3], [4] is the highest number of chunks possible.
 *  * Note:
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class Q211_MaxChunksToMakeSorted {
    public static void main(String[] args) {
//        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{2, 0, 1}));
//        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1}));
//        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1, 2}));
//        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{3, 2}));
        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
//        System.out.println(new Q211_MaxChunksToMakeSorted().maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    }

    // O(1) && O(n)
    public int maxChunksToSorted_1_space(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }


    //Algorithm:
    //Iterate through the array, each time all elements to the left are smaller (or equal) to all elements
    //to the right, there is a new chunck.
    //Use two arrays to store the left max and right min to achieve O(n) time complexity. Space complexity is O(n) too.
    //This algorithm can be used to solve ver2 too.
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1])
                res++;
        }

        return res + 1;
    }
}
