package com.code.test.problemset.leetcode;

/**
 * Range Sum Query - Mutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * <p>
 * <p>
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 * <p>
 * https://leetcode.com/problems/range-sum-query-mutable/
 * <p>
 * https://www.youtube.com/watch?v=0l3xN3BpxHg
 */
public class Q201_RangeSumQuery {
    static class NumArray_Naive {
        int[] nums;

        public NumArray_Naive(int[] nums) {
            this.nums = nums;
        }

        public void update(int i, int val) {
            if (i < 0 || i > nums.length)
                return;
            nums[i] = val;

        }

        public int sumRange(int i, int j) {
            if (i < 0 || i > nums.length || j < 0 || j > nums.length || i > j)
                return 0;

            int total = 0;
            for (int k = i; k < j; k++) {
                total += nums[k];
            }
            return total;
        }
    }

    public static void main(String[] args) {
        NumArraySegmentTree arr = new NumArraySegmentTree(new int[]{2, 4, 5, 7, 8, 9});

        arr.update(2, 6);
        arr.sumRange(2, 5);

    }

    static class NumArraySegmentTree {
        int[] tree;
        int n;

        public NumArraySegmentTree(int[] nums) {
            if (nums.length > 0) {
                n = nums.length;
                tree = new int[n * 2];
                buildTree(nums);
            }
        }

        private void buildTree(int[] nums) {
            for (int i = n, j = 0; i < 2 * n; i++, j++)
                tree[i] = nums[j];
            for (int i = n - 1; i > 0; --i)
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }


        void update(int pos, int val) {
            pos += n;
            tree[pos] = val;
            while (pos > 0) {
                int left = pos;
                int right = pos;
                if (pos % 2 == 0) {
                    right = pos + 1;
                } else {
                    left = pos - 1;
                }
                // parent is updated after child is updated
                tree[pos / 2] = tree[left] + tree[right];
                pos /= 2;
            }
        }

        public int sumRange(int l, int r) {
            // get leaf with value 'l'
            l += n;
            // get leaf with value 'r'
            r += n;
            int sum = 0;
            while (l <= r) {
                if ((l % 2) == 1) { // right child
                    sum += tree[l];
                    l++;
                }
                if ((r % 2) == 0) { // left child
                    sum += tree[r];
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }
}
