package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
 */
public class _KthLargest {
    public static void main(String[] args) {
        _KthLargest kthLargest = new _KthLargest(1, new int[]{});
        System.out.println("4 : " + kthLargest.add(-3));   // returns 4
        System.out.println("4 : " + kthLargest.add(-2));   // returns 4
        System.out.println("4 : " + kthLargest.add(-4));   // returns 4
        System.out.println("4 : " + kthLargest.add(0));   // returns 4
        System.out.println("4 : " + kthLargest.add(4));   // returns 4
    }

    List<Integer> numbers;
    int k;

    public _KthLargest(int k, int[] nums) {
        this.k = k;
        numbers = new ArrayList<>();
        Arrays.stream(nums).forEach(numbers::add);
        Collections.sort(numbers);
    }

    public int add(int val) {
        addSorted(val, 0, numbers.size() - 1);
        return numbers.get(numbers.size() - k);
    }

    private void addSorted(int val, int lo, int hi) {
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = (hi + lo) / 2;
            if (val < numbers.get(mid))
                hi = mid - 1;
            else if (val > numbers.get(mid))
                lo = mid + 1;
            else {
                numbers.add(mid, val);
                return;
            }
        }

        numbers.add(lo, val);
    }
}