package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

import java.util.*;

/**
 * Kth Largest Element in a Stream
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Initialization Time Complexity (Constructor): (O(n \log k))
 * Add Method Time Complexity: (O(\log k)) per call
 * Space Complexity: (O(k))
 */
@Easy
public class _KthLargest {
    public static void main(String[] args) {
        _KthLargest kthLargest = new _KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("4 : " + kthLargest.add(3));   // returns 4
        System.out.println("4 : " + kthLargest.add(5));   // returns 4
        System.out.println("4 : " + kthLargest.add(10));   // returns 4
        System.out.println("4 : " + kthLargest.add(9));   // returns 4
        System.out.println("4 : " + kthLargest.add(4));   // returns 4

    }

    //    List<Integer> numbers;
    static int k;
    static PriorityQueue<Integer> minHeap;

    public _KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        Arrays.stream(nums).forEach(this::add);
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}