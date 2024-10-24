package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

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
@Easy
public class Q43_FirstBadVersion {

    public static void main(String[] args) {
        firstBadVersion_(4);
    }

    static public int firstBadVersion_(int n) {
        int lo = 0;
        int hi = n;
        int lastBadVersion = n;
        while(lo<= hi){
            int mid = lo + (hi-lo) / 2;// To prevent overflow from int + int to 2^31

            boolean bad = isBadVersion(mid);
            if(bad){
                lastBadVersion = mid;
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return lastBadVersion;
    }


    static public int firstBadVersion(int n) {
        return helper(1, n);
    }

    static public int helper(int i, int j) {
        int m = (j + i) / 2;

        if (i >= j)
            return i;

        if (isBadVersion(m)) {
            return helper(i, m);
        } else {
            return helper(m + 1, j); //not bad, left --> m+1
        }
    }

    static private boolean isBadVersion(int m) {
        return true;
    }
}
