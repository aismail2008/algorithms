package com.code.test.problemset.sort;

import java.util.Arrays;

/**
 * Created by aliismail on 07/11/2017.
 */
public class MergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]) {
        MergeSort mms = new MergeSort();

        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        mms.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        inputArr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        mms.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");


        inputArr = new int[]{9, 80, 71, 36, 0, 55, 14, 23, -1, 1};
        mms.sort(inputArr);
        Arrays.stream(inputArr).forEach((i) -> System.out.print(i + " "));
        System.out.println("\n===");

        mms.sort(null);
        mms.sort(new int[1]);
    }

    public void sort(int[] inputArr) {
        if (inputArr == null)
            return;
        if (inputArr.length == 1) {
            return;
        }

        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int k = lowerIndex;
        int j = middle + 1;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
