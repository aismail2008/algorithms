package com.code.test.problemset.companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Slow Sums
 * Suppose we have a list of N numbers, and repeat the following operation until we're left with only a single number: Choose any two consecutive numbers and replace them with their sum. Moreover, we associate a penalty with each operation equal to the value of the new number, and call the penalty for the entire list as the sum of the penalties of each operation.
 * Note: Consecutive numbers means that their indices in the array are consecutive, not that their values are consecutive.
 * For example, given the list [1, 2, 3, 4, 5], we could choose 2 and 3 for the first operation, which would transform the list into [1, 5, 4, 5] and incur a penalty of 5. The goal in this problem is to find the worst possible penalty for a given input.
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
 * First, add 4 + 2 for a penalty of 6. Now the array is [6, 1, 3]
 * Add 6 + 1 for a penalty of 7. Now the array is [7, 3]
 * Add 7 + 3 for a penalty of 10. The penalties sum to 23.
 *
 *
 * The complexity is O(n²), BUT in most of the cases, it will be O(n).
 *
 */
public class SlowSum {

    static class MySolution {
        static int getTotalTime(int[] arr) {
            List<Integer> output = new ArrayList<>();
            Arrays.stream(arr).forEach(output::add);
            if (output.size() < 3) {
                return output.stream().reduce((a, b) -> a + b).get();
            }

            int sum = 0;
            List<Integer> max1 = new ArrayList<>();
            max1.add(0);
            for (int i = 2; i < output.size(); i++) {
                if (output.get(i) + output.get(i - 1) > output.get(max1.get(0)) + output.get(max1.get(0) + 1)) {
                    max1 = new ArrayList<>();
                    max1.add(i - 1);
                } else if (output.get(i) + output.get(i - 1) == output.get(max1.get(0)) + output.get(max1.get(0) + 1)) {
                    max1.add(i - 1);
                }
            }

            sum = sum + output.get(max1.get(0)) + output.get(max1.get(0) + 1);

            List newList = new ArrayList(output);
            newList.set(max1.get(0), output.get(max1.get(0)) + output.get(max1.get(0) + 1));
            newList.remove(max1.get(0) + 1);

            int remainingSum = getTotalTime(newList);

            for (int i = 1; i < max1.size(); i++) {
                newList = new ArrayList(output);
                newList.set(max1.get(i), output.get(max1.get(i)) + output.get(max1.get(i) + 1));
                newList.remove(max1.get(i) + 1);
                int nextRemainingSum = getTotalTime(newList);
                if (nextRemainingSum > remainingSum) {
                    remainingSum = nextRemainingSum;
                }
            }
            sum += remainingSum;

            return sum;
        }

        static int getTotalTime(List<Integer> output) {
            int sum = 0;
            while (output.size() > 2) {
                int max1 = 0;
                for (int i = 2; i < output.size(); i++) {
                    if (output.get(i) + output.get(i - 1) > output.get(max1) + output.get(max1 + 1)) {
                        max1 = i - 1;
                    }
                }
                sum += output.get(max1) + output.get(max1 + 1);
                output.set(max1, output.get(max1) + output.get(max1 + 1));
                output.remove(max1 + 1);
            }

            return sum + output.stream().reduce((a, b) -> a + b).get();
        }

        public static void main(String[] args) {
            getTotalTime(new int[]{2, 3, 9, 8, 4});
            getTotalTime(new int[]{4, 2, 1, 3});
            getTotalTime(new int[]{1, 4, 0, 2, 1, 4, 1, 4, 1, 3});
        }
    }
}
