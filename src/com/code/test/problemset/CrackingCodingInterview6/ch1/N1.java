package com.code.test.problemset.CrackingCodingInterview6.ch1;

import java.util.Scanner;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class N1 {

    /**
     * This approach assumes ASCII char set(8 bits).
     * The idea is to maintain a boolean array for the characters.
     * The 256 indices represent 256 characters. All the array elements are initially set to false.
     * As we iterate over the string, set true at the index equal to the int value of the character.
     * If at any time, we encounter that the array value is already true, it means the character with that int value is repeated.
     */
    public static boolean isAllUnique(String str) {
        boolean[] asciis = new boolean[256];

        for (char ch : str.toCharArray()) {
            int index = ch;
            if (asciis[index] == true) {
                return false;
            }

            asciis[index] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Is All Unique : " + isAllUnique(sc.nextLine()));
        }
    }
}