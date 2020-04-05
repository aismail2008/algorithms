package com.code.test.problemset.leetcode.CodingInterview3;

/**
 * Created by aliismail on 27/11/2017.
 */
public class N42 {
    public String longestCommonPrefix(String[] strs) {
        String curr = strs[0];
        int j = 0;
        for (; j < curr.length(); j++) {
            char prev = curr.charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length() == j)
                    return strs[i];

                if (strs[i].charAt(j) != prev) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, j);
    }
}
