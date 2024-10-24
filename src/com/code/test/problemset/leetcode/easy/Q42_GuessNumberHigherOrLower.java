package com.code.test.problemset.leetcode.easy;

import com.code.test.problemset.leetcode.Easy;

/**
 * Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
@Easy
public class Q42_GuessNumberHigherOrLower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    private int guess(int mid) {
        return 0;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if(res == 0){
                return mid;
            }else if(res == 1){
                low = mid +1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
