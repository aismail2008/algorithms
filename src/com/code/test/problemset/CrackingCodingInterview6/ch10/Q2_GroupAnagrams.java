package com.code.test.problemset.CrackingCodingInterview6.ch10;

import com.code.test.problemset.leetcode.Q98_GroupAanagrams;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * <p>
 * https://leetcode.com/problems/group-anagrams
 */
public class Q2_GroupAnagrams {
    public static void main(String[] args) {
        Q98_GroupAanagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
