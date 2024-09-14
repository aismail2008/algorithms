package com.code.test.problemset.companies.adyen;

/**
 *
 * There are N nails hammered into the same block of wood. Each nail sticks out of the wood at some length.

 You can choose at most Y nails and hammer them down to any length between their original lengths and 0.

 Nails cannot be pulled up. The goal is to have as many nails of the same length as possible.

 Write a function:

 class Solution { public int solution(int[] A, int Y); }

 which, given an array A of N integers representing the length of each nail and an integer Y representing the maximum number of nails that can be hammered down, returns the maximum number of nails that can be positioned at the same length after hammering down at most Y nails.

 For example, given Y = 2 `and array A = [1, 1, 3, 3, 3, 4, 5, 5, 5, 5] the function should return 5. One

 of the possibilities is to hammer the nails represented by A[8] and A[9] down to length 3.

 Write an efficient algorithm for the following assumptions:

 Array A is sorted in ascending order. N is an integer within the range [1.. 10,000].

 Y is an integer within the range [0.. N].

 Each element of array A is an integer within the range [1.. 1,000,000,000].

 In your solution, focus on correctness and performance.
 *
 */
public class Nails {
    public int solution(int[] arr, int y) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;

            while (i + 1 < arr.length && arr[i] == arr[i+1]) {
                curr++;
                i++;
            }
            if(i != arr.length - 1)
                curr += i + y <= arr.length - 1 ? y : arr.length - i - 1;
            maxLength = Math.max(curr, maxLength);
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        new Nails().solution(new int[]{1}, 5);
    }
}
