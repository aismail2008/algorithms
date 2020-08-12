package com.code.test.problemset.basics.datastructure;

public class SegmentTreeNode {
    public static void main(String[] args) {
        SegmentTree arr = new SegmentTree(new int[]{2, 4, 5, 7, 8, 9});

        arr.update(2, 6);
        System.out.println(arr.sumRange(2, 5));
        System.out.println(arr.sumRange(0, 5));
        System.out.println(arr.sumRange(1, 3));
        System.out.println(arr.sumRange(4, 4));
        System.out.println(arr.sumRange(4, 9));
        System.out.println(arr.sumRange(9, 10));
        System.out.println(arr.sumRange(90, 100));

    }

    static class Node {
        int startRange;
        int endRange;
        int sum;
        Node left;
        Node right;
        Node parent;

        public Node(int startRange, int endRange) {
            this.startRange = startRange;
            this.endRange = endRange;
        }

        public Node(int startRange, int endRange, int sum) {
            this.startRange = startRange;
            this.endRange = endRange;
            this.sum = sum;
        }
    }

    static class SegmentTree {
        Node tree;

        public SegmentTree(int[] nums) {
            tree = buildTree(nums, 0, nums.length - 1, null);
        }

        private Node buildTree(int[] nums, int st, int en, Node parent) {
            if (en == st) {
                Node n = new Node(st, en, nums[st]);
                n.parent = parent;
                return n;
            }

            int mid = (st + en) / 2;
            Node n = new Node(st, en);
            n.left = buildTree(nums, st, mid, n);
            n.right = buildTree(nums, mid + 1, en, n);
            n.sum = n.left.sum + n.right.sum;

            n.parent = parent;

            return n;
        }

        public int sumRange(int r, int l) {
            return getSumRange(tree, r, l);
        }

        private int getSumRange(Node root, int r, int l) {
            if (root == null)
                return 0;
            // case 1: Node completely within range => return node value
            if (root.startRange >= r && l >= root.endRange)
                return root.sum;

            //  case 2: Node completely outside range => return 0
            if (root.endRange < r || l < root.startRange)
                return 0;

            //case 1: Node partially overlaps => recursive return sum of (left and right) children
            return getSumRange(root.right, r, l) + getSumRange(root.left, r, l);
        }

        public void update(int i, int val) {
            updateUtil(tree, i, val);
        }

        private void updateUtil(Node root, int i, int val) {
            if (root == null)
                return;

            if (root.startRange == root.endRange && root.startRange == i) {
                int diff = val - root.sum;
                root.sum = val;
                updateParents(root.parent, diff);
                return;
            }

            //  case 2: Node completely outside range => return 0
            if (root.endRange < i || i < root.startRange)
                return;

            //case 1: Node partially overlaps => recursive return sum of (left and right) children
            updateUtil(root.left, i, val);
            updateUtil(root.right, i, val);

        }

        private void updateParents(Node parent, int diff) {
            while (parent != null) {
                parent.sum += diff;
                parent = parent.parent;
            }
        }
    }
}
