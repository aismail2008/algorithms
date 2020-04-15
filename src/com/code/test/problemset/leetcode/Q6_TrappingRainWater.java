package com.code.test.problemset.leetcode;

/**
 * Given n non-negative integers representing an
 * elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/
 */
@Hard
public class Q6_TrappingRainWater {

    public static void main(String[] args) {
        trap(new int[]{1, 2, 3, 4});
    }

    /**
     * Min(Highest bar on my left,  highest bar on my right) - my height => is how much i can hold under i
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int result = 0;

        if (height == null || height.length <= 2)
            return result;

        int left[] = new int[height.length];
        int right[] = new int[height.length];

        //scan from left to right
        int max = height[0];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] < max) {
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }

        //scan from right to left
        max = height[height.length - 1];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] < max) {
                right[i] = max;
            } else {
                right[i] = height[i];
                max = height[i];
            }
        }

        //calculate totoal
        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
