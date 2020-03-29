package com.code.test.problemset.CrackingCodingInterview6.ch1;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class N5 {

    public static boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean isSameSize = s1.length() == s2.length();
        boolean foundDiff = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (foundDiff) {
                    return false;
                }

                if (isSameSize) { // replace
                    index1++;
                }

                foundDiff = true;
                index2++;
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
