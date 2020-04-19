package com.code.test.problemset.CrackingCodingInterview6.ch16;

import java.util.HashSet;

/**
 * Diving Board:
 * You are building a diving board by placing a bunch of planks of wood end-to-end.
 * There are two types of planks, one of length shorter and one of length longer. You must use
 * exactly K planks of wood. Write a method to generate all possible lengths for the diving board.
 */
public class Q11_DivingBoard {
    public static int counter = 0;

    public static HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths;
    }

    public static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
        counter++;
        if (k == 0) {
            lengths.add(total);
            return;
        }
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths);
    }

    public static void main(String[] args) {
        HashSet<Integer> lengths = allLengths(12, 1, 3);
        System.out.println(lengths.toString());
        System.out.println(counter);
    }
}
