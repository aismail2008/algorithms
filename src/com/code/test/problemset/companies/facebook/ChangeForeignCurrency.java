package com.code.test.problemset.companies.facebook;

import com.code.test.problemset.CrackingCodingInterview6.ch8.Q11_Coins;

/**
 * Change in a Foreign Currency
 * You likely know that different currencies have coins and bills of different denominations. In some currencies, it's actually impossible to receive change for a given amount of money. For example, Canada has given up the 1-cent penny. If you're owed 94 cents in Canada, a shopkeeper will graciously supply you with 95 cents instead since there exists a 5-cent coin.
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of money targetMoney. Both the denominations and target amount will be given in generic units of that currency.
 * Signature
 * boolean canGetExactChange(int targetMoney, int[] denominations)
 * Input
 * 1 ≤ |denomintaions| ≤ 100
 * 1 ≤ denominations[i] ≤ 10,000
 * 1 ≤ targetMoney ≤ 1,000,000
 * Output
 * Return true if it's possible to receive exactly targetMoney given the available denominations, and false if not.
 * Example 1
 * denominations = [5, 10, 25, 100, 200]
 * targetMoney = 94
 * output = false
 * Every denomination is a multiple of 5, so you can't receive exactly 94 units of money in this currency.
 * Example 2
 * denominations = [4, 17, 29]
 * targetMoney = 75
 * output = true
 * You can make 75 units with the denominations [17, 29, 29].
 */
public class ChangeForeignCurrency {

    boolean canGetExactChange(int targetMoney, int[] denominations) {
        new Q11_Coins().makeChange(targetMoney, denominations);
        int ways = new Q11_Coins().makeChange(targetMoney, denominations);
        if (ways > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new ChangeForeignCurrency().canGetExactChange(94, new int[]{5, 10, 25, 100, 200});
    }
}
