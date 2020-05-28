package com.code.test.problemset.leetcode;

/**
 *
 * Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class Q185_UniqueBinarySearchTrees {

    // https://www.youtube.com/watch?v=YDf982Lb84o
    //
    //  i=0, count[0]=1 //empty tree
    //
    //  i=1, count[1]=1 //one tree
    //
    //  i=2, count[2]=count[0]*count[1] // One root, zero left and one right
    //              + count[1]*count[0] // One root, zero right and one left
    //
    //  i=3, count[3]=count[0]*count[2] // One root, two right and zero left
    //              + count[1]*count[1] // One root, one right and one left
    //              + count[2]*count[0] // One root, zero right and two left
    //
    //  i=4, count[4]=count[0]*count[3] // One root, 0 right and 3 left
    //            + count[1]*count[2] // One root, 1 right and 2 left
    //            + count[2]*count[1] // One root, 2 right and 1 left
    //            + count[3]*count[0] /// One root, 0 right and 3 left
    //
    //      count[n] =  count[0]*count[n-1]
    //                + count[1]*count[n-2]+
    //                + count[2]*count[n-3]+
    //                 .....
    //                + count[n-1]*count[0]+
    //
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
