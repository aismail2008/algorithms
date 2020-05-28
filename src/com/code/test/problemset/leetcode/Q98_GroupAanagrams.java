package com.code.test.problemset.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Group Anagrams :
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
public class Q98_GroupAanagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static List<List<String>> groupAnagrams(String[] array) {
        HashMap<String, List<String>> mapList = new HashMap<>();

        /* Group words by anagram */
        for (String s : array) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> lst = mapList.getOrDefault(key, new ArrayList<>());
            lst.add(s);
            mapList.put(key, lst);
        }

        List<List<String>> lst = mapList.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return lst;
    }
}
