package com.code.test.problemset.CrackingCodingInterview6.ch4;


import com.code.test.problemset.basics.datastructure.TreeNode;

import java.util.HashMap;

/**
 * Paths with Sum:
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */
public class Q12_PathsWithSum {

    //O(N2)
    static class SolutionA {

        public static int countPathsWithSum(TreeNode root, int targetSum) {
            if (root == null) return 0;

            /* Count paths with sum starting from the root. */
            int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

            /* Try the nodes on the left and right. */
            int pathsOnLeft = countPathsWithSum(root.left, targetSum);
            int pathsOnRight = countPathsWithSum(root.right, targetSum);

            return pathsFromRoot + pathsOnLeft + pathsOnRight;
        }

        /* Returns the number of paths with this sum starting from this node. */
        public static int countPathsWithSumFromNode(TreeNode treeNode, int targetSum, int currentSum) {
            if (treeNode == null) return 0;

            currentSum += treeNode.key;

            int totalPaths = 0;
            if (currentSum == targetSum) { // Found a path from the root
                totalPaths++;
            }

            totalPaths += countPathsWithSumFromNode(treeNode.left, targetSum, currentSum); // Go left
            totalPaths += countPathsWithSumFromNode(treeNode.right, targetSum, currentSum); // Go right

            return totalPaths;
        }
    }

    //Didn't review this solution well
    static class QuestionB {

        public static int countPathsWithSum(TreeNode root, int targetSum) {
            return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
        }

        public static int countPathsWithSum(TreeNode treeNode, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
            if (treeNode == null) return 0; // Base case

            runningSum += treeNode.key;

            /* Count paths with sum ending at the current node. */
            int sum = runningSum - targetSum;
            int totalPaths = pathCount.getOrDefault(sum, 0);

            /* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
            if (runningSum == targetSum) {
                totalPaths++;
            }

            /* Add runningSum to pathCounts. */
            incrementHashTable(pathCount, runningSum, 1);

            /* Count paths with sum on the left and right. */
            totalPaths += countPathsWithSum(treeNode.left, targetSum, runningSum, pathCount);
            totalPaths += countPathsWithSum(treeNode.right, targetSum, runningSum, pathCount);

            incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
            return totalPaths;
        }

        public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
            int newCount = hashTable.getOrDefault(key, 0) + delta;
            if (newCount == 0) { // Remove when zero to reduce space usage
                hashTable.remove(key);
            } else {
                hashTable.put(key, newCount);
            }
        }
    }
}
