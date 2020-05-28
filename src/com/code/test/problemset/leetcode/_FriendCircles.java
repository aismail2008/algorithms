package com.code.test.problemset.leetcode;

/**
 * Friend Circles
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * <p>
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * <p>
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * <p>
 * https://leetcode.com/problems/friend-circles
 */
public class _FriendCircles {
    static class Solution {
        public static void main(String[] args) {
            new Q37_SearchInsertPosition().searchInsert(null, 0);
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}};
        int total = new _FriendCircles().findCircleNum(M);
        System.out.println(total);

        M = new int[][]{{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        total = new _FriendCircles().findCircleNum(M);
        System.out.println(total);

        M = new int[][]{{1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        total = new _FriendCircles().findCircleNum(M);
        System.out.println(total);
    }

    boolean[] visited;

    public int findCircleNum(int[][] M) {
        visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i);
                total++;
            }
        }
        return total;
    }

    int total = 0;

    public void dfs(int[][] m, int i) {
        visited[i] = true;
        for (int j = 0; j < m[i].length; j++) {
            if (!visited[j] && m[i][j] == 1) {
                dfs(m, j);
            }
        }
    }
}
