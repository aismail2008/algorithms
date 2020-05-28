package com.code.test.problemset.companies.facebook;

/**
 * Matching Pairs
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively.
 * The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
 * Note: This means you must swap two characters at different indices.
 * Signature
 * int matchingPairs(String s, String t)
 * Input
 * s and t are strings of length N
 * N is between 2 and 1,000,000
 * Output
 * Return an integer denoting the maximum number of matching pairs
 * Example 1
 * s = "abcd"
 * t = "adcb"
 * output = 4
 * Explanation:
 * Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
 * Therefore, the number of matching pairs of s and t will be 4.
 * Example 2
 * s = "mno"
 * t = "mno"
 * output = 1
 * Explanation:
 * Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
 */
public class MatchingPairs {

    // Add any helper functions you may need here
    static String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    int matchingPairs(String s, String t) {
        System.out.println("Swaping : " + s + " with : " + t);
        if (s.equals(t)) {
            return s.length() - 2;
        }

        int i = 0;
        int count = 0;
        boolean swap = false;
        int maxCount = 0;
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(i) && swap) {

                maxCount = Math.max(maxCount, count);
                count = 0;
                swap = false;
                continue;
            } else if (s.charAt(i) != t.charAt(i)) {
                int index = s.indexOf(t.charAt(i), i + 1);
                if (index >= 0) {
                    // swap i & index
                    s = swap(s, i, index);
                    swap = true;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                    swap = false;
                    continue;
                }
            }
            i++;
            count++;
        }

        return Math.max(maxCount, count);

    }

    public static void main(String[] args) {
        new MatchingPairs().matchingPairs("abcdefhij", "acbedfhij");
        new MatchingPairs().matchingPairs("abcd", "adcb");
    }
}
