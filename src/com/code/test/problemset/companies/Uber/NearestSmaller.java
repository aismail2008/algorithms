package com.code.test.problemset.companies.Uber;

/**
 * Created by aliismail on 27/11/2017.
 */
public class NearestSmaller {
// Given an array of integers, find the nearest smaller number
// for every element such that the smaller element is on left side.
//    I solve it Using Insertion Sort
    public static int[] nearestSmaller(int[] a) {
        int[] sol = new int[a.length];
        sol[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            int cur = a[i];
            for (int j = i; j > 0; j--) {
                if(a[j] < a[j-1]){
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                }else
                    break;
            }

            if(a[0] != cur)
                sol[i] = a[0];
            else
                sol[i] = a[1];
        }

        return sol;
    }
}
