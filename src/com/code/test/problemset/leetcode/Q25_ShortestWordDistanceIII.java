package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a follow-up problem of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 * <p>
 * https://leetcode.com/problems/shortest-word-distance-iii/
 */
public class Q25_ShortestWordDistanceIII {
    HashMap<String, ArrayList<Integer>> map;

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0)
            return -1;

        if (word1 == null || word2 == null)
            return -1;

        boolean isSame = false;

        if (word1.equals(word2))
            isSame = true;

        int shortest = Integer.MAX_VALUE;

        int prev = -1;
        int i1 = -1;
        int i2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (isSame) {
                if (words[i].equals(word1)) {
                    if (prev != -1) {
                        shortest = Math.min(shortest, i - prev);
                    }
                    prev = i;
                }
            } else {
                if (word1.equals(words[i])) {
                    i1 = i;
                    if (i2 != -1) {
                        shortest = Math.min(shortest, i - i2);
                    }
                } else if (word2.equals(words[i])) {
                    i2 = i;
                    if (i1 != -1) {
                        shortest = Math.min(shortest, i - i1);
                    }
                }
            }
        }

        return shortest;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int m = -1;
        int n = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (word1.equals(s)) {
                m = i;
                if (n != -1)
                    min = Math.min(min, m - n);
            } else if (word2.equals(s)) {
                n = i;
                if (m != -1)
                    min = Math.min(min, n - m);
            }
        }

        return min;
    }
}
