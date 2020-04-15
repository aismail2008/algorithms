package com.code.test.problemset.leetcode;

/**
 * Sorted Search, No Size:
 * You are given an array-like data structure Listy which lacks a size
 * method. It does, however, have an elementAt ( i) method that returns the element at index i in
 * 0( 1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
 * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 *
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class _SortedSearchNoSize {
    static class Listy {
        int[] array;

        public Listy(int[] arr) {
            array = arr.clone();
        }

        public int elementAt(int index) {
            if (index >= array.length) {
                return -1;
            }
            return array[index];
        }
    }

    public static int binarySearch(Listy a, int key, int lo, int hi) {
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            int middle = a.elementAt(mid);
            if (key < middle || middle == -1)
                hi = mid - 1;
            else if (key > middle)
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int search(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySearch(list, value, index / 2, index);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println(search(list, a));
        }
        System.out.println(search(list, 15));
    }
}
