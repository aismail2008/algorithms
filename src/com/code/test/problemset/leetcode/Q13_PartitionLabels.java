package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Partition Labels:
 * A string S of lowercase letters is given.
 * We want to partition this string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * <p>
 * https://leetcode.com/problems/partition-labels/
 */
public class Q13_PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int[] range = map.getOrDefault(c, new int[]{-1, -1});
            if (range[0] == -1) {
                range[0] = i;
                range[1] = i;
            } else {
                range[1] = i;
            }
            map.put(c, range);
        }

        int[] temp = null;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] curr = entry.getValue();
            if (temp == null) {
                temp = curr;
            } else {
                if (curr[0] < temp[1]) {
                    temp = new int[]{temp[0], Math.max(curr[1], temp[1])};
                } else {
                    result.add(temp[1] - temp[0] + 1);
                    temp = curr;
                }
            }
        }

        result.add(temp[1] - temp[0] + 1);

        return result;
    }

    static class SolutionAli {
        static public List<Integer> partitionLabels_(String s) {
            List<Integer> output = new ArrayList<>();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), i);
            }

            for (int i = 0; i < s.length(); i++) {
                int max = map.get(s.charAt(i));
                int st = i;
                while (i + 1 <= max) {
                    i++;
                    max = Math.max(max, map.get(s.charAt(i)));
                }
                output.add(i - st + 1);
            }

            if (output.size() == 0)
                output.add(s.length());
            return output;
        }
    }

}
