package com.code.test.problemset.leetcode;

/**
 * One Away:
 *  There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 *
 * One Edit Distance (Java)
 *
 *      Given two strings S and T, determine if they are both one edit distance apart.
 *
 *  https://leetcode.com/problems/one-edit-distance/
 */
public class Q16_OneEditAway {

    public static boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;

        int sIndex = 0;
        int lIndex = 0;
        boolean isSameSize = shorter.length() == longer.length();
        boolean foundDiff = false;
        while (lIndex < longer.length() && sIndex < shorter.length()) {
            if (shorter.charAt(sIndex) == longer.charAt(lIndex)) {
                sIndex++;
                lIndex++;
            } else {
                if (foundDiff) {
                    return false;
                }

                if (isSameSize) { // replace
                    sIndex++;
                }

                foundDiff = true;
                lIndex++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "pale";
        String b = "ple";
        boolean isOneEdit1 = oneEditAway(a, b);
        System.out.println("Should be True: " + a + ", " + b + ": " + isOneEdit1);

        String c = "pales";
        String d = "pale";
        boolean isOneEdit2 = oneEditAway(c, d);
        System.out.println("Should be True: " + c + ", " + d + ": " + isOneEdit2);

        a = "pale";
        b = "bale";
        isOneEdit1 = oneEditAway(a, b);
        System.out.println("Should be True: " + a + ", " + b + ": " + isOneEdit1);

        a = "pale";
        b = "bake";
        isOneEdit1 = oneEditAway(a, b);
        System.out.println("Should be False: " + a + ", " + b + ": " + isOneEdit1);
    }
}
