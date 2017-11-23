package com.code.test.problemset.book.CodingInterview3;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N19 {
//    Given an array of n positive integers and a positive integer s,
//    find the minimal length of a subarray of which the sum s. If there isn’t one, return 0 instead.
//    For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the problem constraint.
    public static void main(String[] args) {
       minSubArrayLen(new int[]{9,4,3}, 7);
    }

    public static int minSubArrayLen(int[] nums, int s) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (sum < s) {
                sum += nums[j];
                j++;
            } else {// sum >= s
                minLen = Math.min(minLen, j - i);
                if (i == j - 1)
                    return 1;

                sum -= nums[i];
                i++;
            }
        }

        while (sum >= s) {
            minLen = Math.min(minLen, j - i);

            sum -= nums[i++];
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // initialize min length to be the input array length
        int result = nums.length;
        int i = 0;
        int sum = nums[0];
        for (int j = 0; j < nums.length; ) {
            if (i == j) {
                if (nums[i] >= s) {
                    return 1; //if single elem is large enough
                } else {
                    j++;
                    if (j < nums.length) {
                        sum = sum + nums[j];
                    } else {
                        return result;
                    }
                }
            } else {
                //if sum is large enough, move left cursor
                if (sum >= s) {
                    result = Math.min(j - i + 1, result);
                    sum = sum - nums[i];
                    i++;
                    //if sum is not large enough, move right cursor
                } else {
                    j++;
                    if (j < nums.length) {
                        sum = sum + nums[j];
                    } else {
                        if (i == 0) {
                            return 0;
                        } else {
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }
}
