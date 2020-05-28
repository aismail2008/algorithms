package com.code.test.problemset.companies.facebook;

import java.awt.desktop.OpenURIEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Slow Sums
 * Suppose we have a list of N numbers, and repeat the following operation until we're left with only a single number:
 * Choose any two consecutive numbers and replace them with their sum. Moreover,
 * we associate a penalty with each operation equal to the value of the new number,
 * and call the penalty for the entire list as the sum of the penalties of each operation.
 * <p>
 * Note: Consecutive numbers means that their indices in the array are consecutive, not that their values are consecutive.
 * <p>
 * For example,
 * given the list [1, 2, 3, 4, 5],
 * we could choose 2 and 3 for the first operation, which would transform the list into [1, 5, 4, 5] and incur a penalty of 5.
 * <p>
 * The goal in this problem is to find the worst possible penalty for a given input.
 * <p>
 * Signature:
 * int getTotalTime(int[] arr)
 * Input:
 * An array arr containing N integers, denoting the numbers in the list.
 * Output format:
 * An int representing the worst possible total penalty.
 * Constraints:
 * 1 ≤ N ≤ 10^6
 * 1 ≤ Ai ≤ 10^7, where *Ai denotes the ith initial element of an array.
 * The sum of values of N over all test cases will not exceed 5 * 10^6.
 * Example
 * arr = [4, 2, 1, 3]
 * output = 23
 * <p>
 * First, add 4 + 2 for a penalty of 6. Now the array is [6, 1, 3]
 * Add 6 + 1 for a penalty of 7. Now the array is [7, 3]
 * Add 7 + 3 for a penalty of 10. The penalties sum to 23.
 * <p>
 * <p>
 * The complexity is O(n²), BUT in most of the cases, it will be O(n).
 */
public class SlowSum {

    static int getTotalTime(int[] arr) {

        List<Integer> output = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (output.size() < 3) {
            return output.stream().reduce((a, b) -> a + b).get();
        }

        int maxSt = 0;
        for (int i = 2; i < output.size(); i++) {
            if (output.get(i) + output.get(i - 1) > output.get(maxSt) + output.get(maxSt + 1)) {
                maxSt = i - 1;
            }
        }

        int sum = output.get(maxSt) + output.get(maxSt + 1);
        output.set(maxSt, output.get(maxSt) + output.get(maxSt + 1));
        output.remove(maxSt + 1);

        while (output.size() > 2) {
            int left = output.get(maxSt) + (maxSt > 0 ? output.get(maxSt - 1) : 0);
            int right = output.get(maxSt) + (maxSt < output.size() - 1 ? output.get(maxSt + 1) : 0);

            if(left < right){
                sum += output.get(maxSt) + output.get(maxSt + 1);
                output.set(maxSt, output.get(maxSt) + output.get(maxSt + 1));
                output.remove(maxSt + 1);
            }else {
                sum += output.get(maxSt) + output.get(maxSt - 1);
                output.set(maxSt, output.get(maxSt) + output.get(maxSt - 1));
                output.remove(maxSt - 1);
                maxSt--;
            }
        }

        return sum + output.stream().reduce((a, b) -> a + b).get();
    }

    // same but without remove or set in the arraylist
    static int getTotalTime_optimized(int[] arr) {
        // Write your code here
        if (arr == null || arr.length == 0)
            return 0;
        int l = -1, r = -1;
        for (int i = 1; i < arr.length; i++) {
            if (l == -1 || arr[i - 1] + arr[i] > arr[l] + arr[r]) {
                l = i - 1;
                r = i;
            }
        }
        int currCost = arr[l] + arr[r];
        int totalCost = currCost;
        l--;
        r++;
        while (l >= 0 || r < arr.length) {
            int left = l < 0 ? Integer.MIN_VALUE : arr[l];
            int right = r >= arr.length ? Integer.MIN_VALUE : arr[r];
            if (left > right) {
                currCost += left;
                totalCost += currCost;
                l--;
            } else {
                currCost += right;
                totalCost += currCost;
                r++;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        getTotalTime(new int[]{2, 3, 9, 8, 4});
        getTotalTime(new int[]{4, 2, 1, 3});
        getTotalTime(new int[]{1, 4, 0, 2, 1, 4, 1, 4, 1, 3});
    }
}
