package com.code.test.problemset.leetcode.CodingInterview3;

/**
 * Created by aliismail on 17/12/2017.
 */
public class N51 {

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;

        binarySearch(nums, 0, nums.length - 1, target, arr);

        return arr;
    }

    public static void binarySearch(int[] nums, int left, int right, int target, int[] arr) {
        if (right < left)
            return;

        if (nums[left] == nums[right] && nums[left] == target) {
            if (arr[0] == -1 || arr[0] > left)
                arr[0] = left;
            if (arr[1] == -1 || arr[1] < right)
                arr[1] = right;
            return;
        }

        int mid = left + (right - left) / 2;


        if (nums[mid] < target) {
            binarySearch(nums, mid + 1, right, target, arr);
        } else if (nums[mid] > target) {
            binarySearch(nums, left, mid - 1, target, arr);
        } else {
            if (arr[0] == -1 || arr[0] > mid)
                arr[0] = mid;
            if (arr[1] == -1 || arr[1] < mid)
                arr[1] = mid;

            //handle duplicates - left
            if (mid - 1 > 0 && nums[mid - 1] == target)
                binarySearch(nums, left, mid - 1, target, arr);
            //handle duplicates - right
            if (mid + 1 < nums.length && nums[mid + 1] == target)
                binarySearch(nums, mid + 1, right, target, arr);
        }
    }
}
