package com.code.test.problemset.CrackingCodingInterview6.Ch1;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin-
 * drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * <p>
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class N4 {
    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        String pali = "aaBaAaa";
        System.out.println(isPermutationOfPalindrome(pali));
    }
}
