package com.code.test.problemset.CrackingCodingInterview6.ch8;

/**
 * Magic Index:
 * A magic index in an array A[ 1.•.n-1] is defined to be an index such that A[ i] = i.
 *      Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 *      FOLLOW UP
 *      What if the values are not distinct?
 */
public class Q3_MagicIndex {

    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int fastMagic_Ali(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }else if (array[i] > i){
                i = array[i];
            }
        }
        return -1;
    }

    public static int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid){
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }
}
