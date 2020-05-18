package com.code.test.problemset.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * https://leetcode.com/problems/decode-ways/
 */
public class _DecodeWays {
    // DP
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            int oneDigit = Integer.valueOf(s.substring(i-1, i));

            int twoDigit = Integer.valueOf(s.substring(i-2, i));

            if(oneDigit >= 1){
                dp[i] += dp[i-1];
            }

            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }

    static int decodeVariations(String s) {
        Queue<String> qu = new LinkedList<>();
        qu.offer(s);

        int cnt = 0;
        while (!qu.isEmpty()) {
            String n = qu.remove();

            if (n.length() == 2) {
                int two = Integer.valueOf(n.substring(0, 2)); // 90
                if (two > 0 && two < 27)
                    cnt++;

                if (n.charAt(1) != '0') {
                    cnt++;
                }
            } else if (n.length() == 1 && !n.equals("0")) {
                cnt++;
            } else if (n.length() > 2) {
                int two = Integer.valueOf(n.substring(0, 2)); // 19
                if (two < 27)
                    qu.offer(n.substring(2));

                if (n.charAt(1) != 0) {
                    qu.offer(n.substring(1));
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(decodeVariations("190"));
    }
}
