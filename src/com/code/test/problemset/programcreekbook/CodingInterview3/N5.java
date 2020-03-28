package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.Arrays;

/**
 * Created by aliismail on 09/11/2017.
 */
public class N5 {
//    There are two sorted arrays A and B of size m and n respectively. Find the median of the
//    two sorted arrays. The overall run time complexity should be O(log (m+n)).

//    1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
//    2) If m1 and m2 both are equal then we are done, and return m1 (or m2)
//    3) If m1 is greater than m2, then median is present in one of the below two subarrays.
//            a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
//            b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
//    4) If m2 is greater than m1, then median is present in one of the below two subarrays.
//            a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
//            b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
//    5) Repeat the above process until size of both the subarrays becomes 2.
//    6) If size of the two arrays is 2 then use below formula to get the median.
//          Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2


    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45, 50}; // 1, 2, 12, 13, 15, 17, 26, 30, 38, 45
        System.out.println(byMathMedian(ar1, ar2));
    }

    //not tested
    public static double byMathMedian(int[] a, int[] b) {
        if (a.length <= 2 && b.length <= 2) {
            return (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
        }

        double meda = 0;
        if (a.length % 2 == 0) {
            meda = (a[a.length / 2 - 1] + a[a.length / 2]) / 2;
        } else {
            meda = a[a.length / 2];
        }

        double medb = 0;
        if (a.length % 2 == 0) {
            medb = (b[b.length / 2 - 1] + b[b.length / 2]) / 2;
        } else {
            medb = b[b.length / 2];
        }

        if (meda == medb) {
            return meda;
        } else if (meda > medb) {
            a = Arrays.copyOfRange(a, 0, a.length / 2);
            b = Arrays.copyOfRange(b, b.length / 2, b.length);
        } else if (medb > meda) {
            a = Arrays.copyOfRange(a, a.length / 2, a.length);
            b = Arrays.copyOfRange(b, 0, b.length / 2);
        }

        return byMathMedian(a, b);
    }

    public static int getKthElement(int[] a, int[] b) {
        boolean next = false;
        int k = (a.length + b.length) / 2 - 1;
        if ((a.length + b.length) % 2 == 0) {
            next = true;
        } else {
            k = (a.length + b.length) / 2 - 1;
            k++;
        }

        int value = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (count <= k) {
            if (a[i] < b[j]) {
                value = a[i];
                i++;
            } else {
                value = b[j];
                j++;
            }
            count++;
        }
        if (next) {
            int value1 = a[i] < b[j] ? a[i] : b[j];
            return (value + value1) / 2;
        } else
            return value;
    }
}
