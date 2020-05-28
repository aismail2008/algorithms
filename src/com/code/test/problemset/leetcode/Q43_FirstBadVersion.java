package com.code.test.problemset.leetcode;

/**
 * First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes
 * all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 *
 * https://leetcode.com/problems/first-bad-version/
 */
public class Q43_FirstBadVersion {

    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    public int helper(int i, int j) {
        int m = i + (j - i) / 2;

        if (i >= j)
            return i;

        if (isBadVersion(m)) {
            return helper(i, m);
        } else {
            return helper(m + 1, j); //not bad, left --> m+1
        }
    }

    private boolean isBadVersion(int m) {
        return true;
    }
}
