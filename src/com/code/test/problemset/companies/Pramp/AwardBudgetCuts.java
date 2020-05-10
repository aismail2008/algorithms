package com.code.test.problemset.companies.Pramp;

import java.util.Arrays;

/**
 * Award Budget Cuts
 * The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they’re facing. Originally, the committee planned to give N research grants this year. However, due to spending cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a decision that they’d like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously, won’t be impacted.
 * <p>
 * Given an array grantsArray of the original grants and the reduced budget newBudget, write a function findGrantsCap that finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget constraint is met (i.e. sum of the N reallocated grants equals to newBudget).
 * <p>
 * Analyze the time and space complexities of your solution.
 * <p>
 * Example:
 * <p>
 * input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190
 * <p>
 * output: 47 # and given this cap the new grants array would be
 * # [2, 47, 47, 47, 47]. Notice that the sum of the
 * # new grants is indeed 190
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.double grantsArray
 * <p>
 * 0 ≤ grantsArray.length ≤ 20
 * 0 ≤ grantsArray[i]
 * [input] double newBudget
 * <p>
 * [output] double
 */
public class AwardBudgetCuts {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        Arrays.sort(grantsArray);
        double capMax = newBudget / grantsArray.length;

        for (int i = 0; i < grantsArray.length; i++) {
            if (grantsArray[i] < capMax) {
                capMax += (capMax - grantsArray[i]) / (grantsArray.length - i - 1);
                continue;
            }
            return capMax;
        }

        return capMax;
    }

    public static void main(String[] args) {
    }
}
