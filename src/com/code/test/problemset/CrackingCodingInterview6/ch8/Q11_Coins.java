package com.code.test.problemset.CrackingCodingInterview6.ch8;

/**
 * Coins:
 * Given an infinite number of quarters (25 cents), dimes (1O cents), nickels (5 cents), and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents
 */
public class Q11_Coins {
    private static int makeChange(int amount, int[] denoms, int index, int[][] memory) {
        if (amount == 0) {//(index >= denoms.length - 1) {
            return 1; //last denom
        } else if (index >= denoms.length) {
            return 0;
        } else if (memory[amount][index] > 0) {//retrieve value
            return memory[amount][index];
        }

        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            ways += makeChange(amount - denomAmount * i, denoms, index + 1, memory);
        }

        memory[amount][index] = ways;
        return ways;
    }

    public static int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms);
    }

    public static int makeChange(int n, int[] denoms) {
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    public static void main(String[] args) {
        System.out.println(makeChange(10));
    }
}
