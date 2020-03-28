package com.code.test.problemset.programcreekbook.CodingInterview3;

/**
 * Created by aliismail on 12/11/2017.
 */
public class N20 {

    public static void main(String[] A) {
//        [1,3,5,6], 5 -> 2
//        [1,3,5,6], 2 -> 1
//        [1,3,5,6], 7 -> 4
//        [1,3,5,6], 0 -> 0
        System.out.println(indexOf(new int[]{1, 3, 5, 6}, 5));
        System.out.println(indexOf(new int[]{1, 3, 5, 6}, 2));
        System.out.println(indexOf(new int[]{1, 3, 5, 6}, 7));
        System.out.println(indexOf(new int[]{1, 3, 5, 6}, 0));
    }

    //    [1,3], 2
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            if (lo == hi) {
                if (key == a[lo])
                    return lo;
                if (key > a[lo]) {
                    return lo + 1;
                } else {
                    return Math.max(lo - 1, 0);
                }
            }
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
