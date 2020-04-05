package com.code.test.problemset.leetcode.CodingInterview3;

import java.util.Arrays;

/**
 * Created by aliismail on 08/11/2017.
 */
public class N1 {
//41, 42, 43, 44, 45, (46), 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 							// 60
//61, 62, 63, 64, 65, 66, (67), 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 							// 80
//81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 							// 100
//101, 102, 103, 104, (105), (106), 107, 108, 109, 110, 111, 112, 113, 117, 118, (119), 121, 122, 125, 126, 	// 120
//127, (128), 133, (134), 135, 136, 137, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151};	// 140



    //    Problem: Rotate an array of n elements to the right by k steps.
//    For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
//    [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
    public static void main(String[] args){
        int[] ar = {1,2,3,4,5,6,7};
        shiftArray(ar, 3);
        Arrays.stream(ar).forEach(System.out::print);
    }


    public static void shiftArray(int[] arr, int k) {
        int j = arr.length - k;
        rotate(arr, 0, j - 1);
        rotate(arr, j, arr.length - 1);
        rotate(arr, 0, arr.length - 1);
    }

    public static void rotate(int[] arr, int left, int right) {
        while (left < right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
    }
}
