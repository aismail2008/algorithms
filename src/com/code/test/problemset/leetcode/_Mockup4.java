package com.code.test.problemset.leetcode;


import java.util.*;

public class _Mockup4 {

    public static void main(String[] args) {
        SolutionA.main(args);
    }

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
    static class KthLargest {
        public static void main(String[] args) {
            KthLargest kthLargest = new KthLargest(1, new int[]{});
            System.out.println("4 : " + kthLargest.add(-3));   // returns 4
            System.out.println("4 : " + kthLargest.add(-2));   // returns 4
            System.out.println("4 : " + kthLargest.add(-4));   // returns 4
            System.out.println("4 : " + kthLargest.add(0));   // returns 4
            System.out.println("4 : " + kthLargest.add(4));   // returns 4
        }

        List<Integer> numbers;
        int k;

        public KthLargest(int k, int[] nums) {
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

    /**
     * 1-bit and 2-bit Characters
     * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
     * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
     * <p>
     * Example 1:
     * Input:
     * bits = [1, 0, 0]
     * Output: True
     * Explanation:
     * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
     * Example 2:
     * Input:
     * bits = [1, 1, 1, 0]
     * Output: False
     * Explanation:
     * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
     * Note:
     * <p>
     * 1 <= len(bits) <= 1000.
     * bits[i] is always 0 or 1.
     * <p>
     * https://leetcode.com/problems/1-bit-and-2-bit-characters/
     */
    static class SolutionA {
        public static void main(String[] args) {
            System.out.println(new SolutionA().isOneBitCharacter(new int[]{1, 1, 0}));
            System.out.println(new SolutionA().isOneBitCharacter(new int[]{1, 1, 1, 0}));
        }

        public boolean isOneBitCharacter(int[] bits) {
            int end = bits.length - 1;
            for (int i = 0; i < end; i++) {
                if (bits[i] == 1) {
                    if (i + 1 >= end) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }
    }
}
