package com.code.test.problemset.leetcode.hard;

import com.code.test.problemset.leetcode.Hard;

import java.util.*;

@Hard
/**
 * 269. Alien Dictionary
 * <p>
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * For example,
 * Given the following words in dictionary,
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 *
 * https://leetcode.com/problems/alien-dictionary/
 */
public class _AlienDictionary {

    // every character in any string add to map with no child
    // add children to each parent in prev map
    // add every child with degree 0
    // for everyparent increment its children degree
    // using queue add parents with degree 0
    // while queue is not empty
    //   get parent with degree 0
    //   decrement all children degree and push only if any child has degree zero
    //
    //

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);

        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new _AlienDictionary().alienOrder(new String[]{"z", "x"});
        new _AlienDictionary().alienOrder(new String[]{"z", "x", "z"});
        new _AlienDictionary().alienOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"});

        new _AlienDictionary().alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        });
    }
}
