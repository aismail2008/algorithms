package com.code.test.problemset.leetcode;

import java.util.*;

/**
 * Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * <p>
 * https://leetcode.com/problems/word-ladder/
 */
public class Q72_WordLadder {
    class WordNode {
        String word;
        int numSteps;

        public WordNode(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        new Q72_WordLadder().ladderLength("hit", "cog", dict);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordDict);
        Set<String> visited = new HashSet<>();
        queue.add(new WordNode(beginWord, 1));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if (word.equals(endWord)) {
                return top.numSteps;
            }

            visited.add(word);

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];

                    if (arr[i] != c) {
                        arr[i] = c;

                        String newWord = new String(arr);
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(new WordNode(newWord, top.numSteps + 1));
                        }

                        arr[i] = temp;
                    }
                }
            }
        }

        return 0;
    }
}
