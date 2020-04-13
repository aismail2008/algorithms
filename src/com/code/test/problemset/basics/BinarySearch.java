package com.code.test.problemset.basics;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2; // or = (hi + lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as a command-line argument; reads in integers from standard input; prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] whitelist = new int[]{1, 10, 15, 30, 45, 85};

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        System.out.println("45 => " + BinarySearch.indexOf(whitelist, 45));
        System.out.println("100 => " + BinarySearch.indexOf(whitelist, 100));
        System.out.println("0 => " + BinarySearch.indexOf(whitelist, 0));
        System.out.println("20 => " + BinarySearch.indexOf(whitelist, 20));

    }
}