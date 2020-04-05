package com.code.test.problemset.CrackingCodingInterview6.ch8;

import com.code.test.problemset.leetcode.Q220_PermutationsWithoutDups;

/**
 * Permutations without Dups:
 * Write a method to compute all permutations of a string of unique characters.
 */
public class Q7_PermutationsWithoutDups {
    public static void main(String[] args) {
        Q220_PermutationsWithoutDups q = new Q220_PermutationsWithoutDups();
        q.stringPermutations("abcde");
        for (String s : q.perm) {
            System.out.println(s);
        }
        System.out.println("============");
    }
}
