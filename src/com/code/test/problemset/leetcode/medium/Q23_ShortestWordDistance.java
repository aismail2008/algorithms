package com.code.test.problemset.leetcode.medium;

import com.code.test.problemset.leetcode.Medium;

import java.util.*;

/**
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * https://leetcode.com/problems/shortest-word-distance/
 */
@Medium
public class Q23_ShortestWordDistance {

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

    //---- optimized for Q24_shortestDistance II -//
    class WordDistance {
        // Store the indices of each word in the dictionary
        private Map<String, List<Integer>> map;

        // Constructor to initialize the data structure with the given word array.
        public WordDistance(List<String> wordsDict) {
            map = new HashMap<>();
            // Store the index for each occurrence of the word
            for (int i = 0; i < wordsDict.size(); ++i) {
                String word = wordsDict.get(i);
                map.putIfAbsent(word, new ArrayList<>());
                map.get(word).add(i);
            }
        }

        // Calculates the shortest distance between two given words in the dictionary.
        public int shortest(String word1, String word2) {
            // Initialize with maximum possible distance
            int minDistance = Integer.MAX_VALUE;

            List<Integer> indices1 = map.get(word1);
            List<Integer> indices2 = map.get(word2);

            // Iterate through the indices of word1 and word2
            int i = 0, j = 0;
            while (i < indices1.size() && j < indices2.size()) {
                int index1 = indices1.get(i);
                int index2 = indices2.get(j);

                // Update the minimum distance if a smaller distance is found
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));

                // If index1 is smaller, move to the next occurrence of word1
                if (index1 < index2) {
                    ++i;
                }
                // Otherwise move to the next occurrence of word2
                else {
                    ++j;
                }
            }

            return minDistance;
        }

        public void main(String[] args) {
            List<String> words = Arrays.asList("hello", "geek", "gfg", "coding", "geek");
            WordDistance wordDistance = new WordDistance(words);

            System.out.println("Shortest distance between 'coding' and 'hello': "
                    + wordDistance.shortest("coding", "hello"));
            System.out.println("Shortest distance between 'geek' and 'coding': "
                    + wordDistance.shortest("geek", "coding"));
        }
    }

}
