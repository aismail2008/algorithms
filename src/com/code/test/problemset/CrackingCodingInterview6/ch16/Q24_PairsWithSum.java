package com.code.test.problemset.CrackingCodingInterview6.ch16;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Pairs with Sum:
 * Design an algorithm to find all pairs of integers within an array which sum to a
 * specified value.
 */
public class Q24_PairsWithSum {
    static class Pair {
        int num1, num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    static HashMap<Integer, Integer> unpairedCount = new HashMap<>();

    public static ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        for (int x : array) {
            int complement = sum - x;
            if (unpairedCount.getOrDefault(complement, 0) > 0) {
                result.add(new Pair(x, complement));
                adjustCounterBy(complement, -1); // decrement complement
            } else {
                adjustCounterBy(x, 1); // increment x
            }
        }
        return result;
    }

    public static void adjustCounterBy(int key, int delta) {
        unpairedCount.put(key, unpairedCount.getOrDefault(key, 0) + delta);
    }


    public static void main(String[] args) {
        int[] test = {-1, -1, -1, -1, 0, 0, 0, 0, 1, 1};
        ArrayList<Pair> pairs = printPairSums(test, -1);
        for (Pair p : pairs) {
            System.out.println(p.toString());
        }
    }
}
