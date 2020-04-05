package com.code.test.problemset.CrackingCodingInterview6.ch8;

/**
 * Coins:
 * Given an infinite number of quarters (25 cents), dimes (1O cents), nickels (5 cents), and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents
 */
public class Q11_Coins {

    public static int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) {//retrieve value
            return map[amount][index];
        }

        int denomAmount = denoms[index];
        if (index >= denoms.length - 1) {
            return 1; //last denom
        }

        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            ways += makeChange(amount - denomAmount * i, denoms, index + 1, map);
        }

        map[amount][index] = ways;
        return ways;
    }

    static int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    public static void main(String[] args) {
        System.out.println(makeChange(10));
    }
}
