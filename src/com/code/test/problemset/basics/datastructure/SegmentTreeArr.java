package com.code.test.problemset.basics.datastructure;

public class SegmentTreeArr {

    static class SegmentTreeLeetCode {
        int[] tree;
        int n;

        public SegmentTreeLeetCode(int[] nums) {
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

        public void update(int pos, int val) {
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
                if ((l % 2) == 1) { //left child
                    sum += tree[l];
                    l++;
                }
                if ((r % 2) == 0) { // right child
                    sum += tree[r];
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }

    static class SegmentTree {
        private int st[]; // The array that stores segment tree nodes

        public SegmentTree(int arr[], int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

            //Maximum size of segment tree
            int max_size = 2 * (int) Math.pow(2, x) - 1;

            st = new int[max_size]; // Memory allocation

            constructSTUtil(arr, 0, n - 1, 0);
        }

        // Preferred and easy to understand
        private int constructSTUtil(int arr[], int ss, int se, int si) {
            // If there is one element in array, store it in current node of
            // segment tree and return
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }

            // If there are more than one elements, then recur for left and
            // right subtrees and store the sum of values in this node
            int mid = (ss + se) / 2;
            st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2);
            return st[si];
        }

        // Return sum of elements in range from index qs (quey start) to
        // qe (query end).  It mainly uses getSumUtil()
        public int getSum(int n, int qs, int qe) {
            // Check for erroneous input values
            if (qs < 0 || qe > n - 1 || qs > qe) {
                System.out.println("Invalid Input");
                return -1;
            }
            return getSumUtil(0, n - 1, qs, qe, 0);
        }

        private int getSumUtil(int ss, int se, int qs, int qe, int si) {
            // If segment of this node is a part of given range, then return
            // the sum of the segment
            if (qs <= ss && qe >= se)
                return st[si];

            // If segment of this node is outside the given range
            if (se < qs || ss > qe)
                return 0;

            // If a part of this segment overlaps with the given range
            int mid = (ss + se) / 2;
            return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                    getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
        }

        public void updateValue(int arr[], int n, int i, int new_val) {
            // Check for erroneous input index
            if (i < 0 || i > n - 1) {
                System.out.println("Invalid Input");
                return;
            }

            // Get the difference between new value and old value
            int diff = new_val - arr[i];

            // Update the value in array
            arr[i] = new_val;

            // Update the values of nodes in segment tree
            updateValueUtil(0, n - 1, 0, i, diff);
        }

        private void updateValueUtil(int ss, int se, int i, int diff, int si) {
            // Base Case: If the input index lies outside the range of
            // this segment
            if (i < ss || i > se)
                return;

            // If the input index is in range of this node, then update the
            // value of the node and its children
            st[si] = st[si] + diff;
            if (se != ss) {
                int mid = (ss + se) / 2;
                updateValueUtil(ss, mid, i, diff, 2 * si + 1);
                updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
            }
        }
    }
}
