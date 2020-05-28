package com.code.test.problemset.companies.facebook;

import java.util.Arrays;

/**
 * Revenue Milestones
 * We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones.
 * Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reached every milestone.
 * Signature
 * int[] getMilestoneDays(int[] revenues, int[] milestones)
 * Input
 * revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N). milestones is a length-K array of total revenue milestones.
 * Output
 * Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue.
 * Example
 * revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 * milestones = [100, 200, 500]
 * output = [4, 6, 10]
 * Explanation
 * On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively. Day 6 is the first time that FB has >= $200 of total revenue.
 */
public class RevenueMilestones {
    public static void main(String[] args) {
        new RevenueMilestones().getMilestoneDays(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, new int[]{100, 200, 500, 10000});
    }

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        for (int i = 1; i < revenues.length; i++) {
            revenues[i] += revenues[i - 1];
        }

        int[] output = new int[milestones.length];
        for (int i = 0; i < milestones.length; i++) {
            int j = Arrays.binarySearch(revenues, milestones[i]);
            if (j < 0) {
                j = -j;
                j--;
                if (j < revenues.length) {
                    while (j < revenues.length && revenues[j] < milestones[i]) {
                        j++;
                    }
                    output[i] = j+1; // NOT J AS it's 1 based index
                } else
                    output[i] = 0;
            } else {
                while (j > 0 && revenues[j] == revenues[j - 1]) {
                    j--;
                }
                output[i] = j + 1; // NOT J AS it's 1 based index
            }
        }
        return output;
    }

}
