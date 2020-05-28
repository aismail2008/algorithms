package com.code.test.problemset.companies.Pramp;

/**
 * Array Index & Element Equality
 * Given a sorted array arr of distinct integers,
 * write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i.
 * Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.
 * <p>
 * Examples:
 * <p>
 * input: arr = [-8,0,2,5]
 * output: 2 # since arr[2] == 2
 * <p>
 * input: arr = [-1,0,3,6]
 * output: -1 # since no index in arr satisfies arr[i] == i.
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 1 ≤ arr.length ≤ 100
 * [output] integer
 */
public class ArrayIndexElementEquality {
    /*
        Solution 1 : iterate over array
         O(n)

        Solution 2 : O(log N) using binarySearch

     */
    static int indexEqualsValueSearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int lastFound = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == arr[mid] && (lastFound == -1 || mid < lastFound)) {
                lastFound = mid;
            }
            //      2       5
            if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastFound;
    }
}
