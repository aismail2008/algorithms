package com.code.test.problemset.book.CodingInterview3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by aliismail on 08/11/2017.
 */
public class N1 {
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
