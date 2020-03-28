package com.code.test.problemset.CrackingCodingInterview6.Ch1;

import java.util.*;

import static com.code.test.problemset.CrackingCodingInterview6.Ch1.N1.isAllUnique;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class N2 {

    public static boolean isPermutaionsOfAnother(String str, String sec) {
        if (str.length() != sec.length()) {
            return false;
        }

        int[] charsCount = new int[256];
        for (int ch : str.toCharArray()) {
            charsCount[ch]++;
        }
        for (int ch : sec.toCharArray()) {
            charsCount[ch]--;
        }

        for (int i : charsCount) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(isPermutaionsOfAnother(sc.nextLine(), sc.nextLine()));
        }
    }
}