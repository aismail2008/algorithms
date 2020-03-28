package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.Arrays;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N16 {
//    Given two sorted integer arrays A and B, merge B into A as one sorted array.
//    Note: You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

    public static void main (String[] args){
        int[] a = new int[]{2, 4, 6, 10, 11, 0, 0};
        int[] b = new int[]{3, 7};
        mergeSorted(a, b);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void mergeSorted(int[] a, int []b){
        int m = b.length - 1;
        int n = a.length - b.length - 1;
        int h = a.length -1;
        while(h > -1 && m >= 0 && n >= 0){
            if(b[m] > a[n]){
                a[h] = b[m];
                m--;
            }else{
                a[h] = a[n];
                n--;
            }
            h--;
        }

        while(m > 0){
            a[h--] = b[m--];
        }
    }
}
