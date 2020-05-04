package com.code.test.problemset.companies.Pramp;

import java.util.Arrays;

public class ArrayOfArrayProducts {
    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return new int[]{};
        }

        int[] leftArr = new int[arr.length];
        leftArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = leftArr[i - 1] * arr[i - 1];
        }

        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            leftArr[i] *= right;
            right *= arr[i];
        }

        return leftArr;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 3, 4};
        int[] output = arrayOfArrayProducts(input);

        Arrays.stream(output).forEach(System.out::println);
    }
}
