package com.code.test.problemset.companies.adyen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Problem Summary:
 * You are tasked with finding the K alphabetically smallest words of length N,
 * where the words are made from the letters "a", "b", and "c" but no two consecutive letters can be the same.
 * The task also specifies that if K is greater than the total number of valid sequences,
 * you should return all valid sequences.
 *
 * Examples Provided:
 * N = 2, K = 4: Expected output is ["ab", "ac", "ba", "bc"].
 * N = 3, K = 20: Expected output is ["aba", "abc", "aca", "acb", "bab",
 * "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"].
 * N = 5, K = 6: Expected output is ["abaca", "abacb", "abcab", "abcac"].
 * The code you provided likely generates some incorrect outputs due to a couple of bugs.
 * Since the problem states that you can modify at most two lines in the implementation, here are the possible bugs and fixes:
 *
 * Potential Bug Areas:
 * Generation of sequences without consecutive duplicates:
 * Ensure that while generating sequences, the condition of no consecutive identical
 * characters is being handled properly.
 *
 *  K limit handling:
 * Ensure the result returns only the first K sequences or all sequences if K is larger
 * than the total number of valid sequences.
 *
 * Suggested Fix: Without the code in front of me, I can suggest the following approach for generating correct sequences:
 *
 * - Use backtracking or depth-first search (DFS) to generate all possible strings of length
 * N that don’t have consecutive identical characters.
 * - Sort the sequences alphabetically and return the first K entries.
 */
public class BugFix {
    public String[] buggySolution(int N, int K) {
        if (N == 0) {
            return new String[]{""};
        }
        if(K > N){
            K = N;
        }

        ArrayList<String> result = new ArrayList<>();
        for (String p : buggySolution(N - 1, K - 1)) {
            for (char l : new char[]{'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    class Solution {
        public String[] solution(int N, int K) {
            // Base case
            if (N == 0) {
                return new String[]{""};
            }

            List<String> result = new ArrayList<>();
            generateWords(N, "", result);

            int prefSize = Math.min(result.size(), K);
            return result.subList(0, prefSize).toArray(new String[prefSize]);
        }

        private void generateWords(int N, String current, List<String> result) {
            if (current.length() == N) {
                result.add(current);
                return;
            }

            for (char l : new char[]{'a', 'b', 'c'}) {
                if (current.isEmpty() || current.charAt(current.length() - 1) != l) {
                    generateWords(N, current + l, result);
                }
            }
        }
    }

}
