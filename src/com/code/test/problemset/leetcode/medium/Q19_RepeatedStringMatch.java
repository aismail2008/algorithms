package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

/**
 * Repeated String Match
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 * <p>
 * https://leetcode.com/problems/repeated-string-match/
 */
@Medium
public class Q19_RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder st = new StringBuilder(A);
        int copies = 1;
        while (st.length() < B.length()) {
            st.append(A);
            copies++;
        }

        if (st.indexOf(B) != -1) {
            return copies;
        } else {
            st.append(A);
        }

        if (st.indexOf(B) != -1) {
            return copies;
        }
        return -1;
    }
}
