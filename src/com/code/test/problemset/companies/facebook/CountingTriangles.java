package com.code.test.problemset.companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Counting Triangles
 * Given a list of N triangles with integer side lengths, determine how many different triangles there are. Two triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy exactly the same three points.
 * Signature
 * int countDistinctTriangles(int[][] triangles)
 * int countDistinctTriangles(Triangle[] triangles)
 * Input
 * In some languages triangles is an Nx3 array where triangles[i] is a length-3 array that contains the side lengths of the ith triangle. In other languages, triangles is a list of structs/objects that each represent a single triangle with side lengths a, b, and c.
 * It's guaranteed that all triplets of side lengths represent real triangles.
 * All side lengths are in the range [1, 1,000,000,000]
 * 1 <= N <= 1,000,000
 * Output
 * Return the number of distinct triangles in the list.
 * Example 1
 * triangles = [[2, 2, 3], [3, 2, 2], [2, 5, 6]]
 * output = 2
 * The first two triangles are the same, so there are only 2 distinct triangles.
 * Example 2
 * triangles = [[8, 4, 6], [100, 101, 102], [84, 93, 173]]
 * output = 3
 * All of these triangles are distinct.
 * Example 3
 * triangles = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
 * output = 1
 * All of these triangles are the same
 */
public class CountingTriangles {
    class Sides {
        int a;
        int b;
        int c;

        Sides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    int countDistinctTriangles(ArrayList<Sides> arr) {
        HashSet<String> set = new HashSet<>();

        for (Sides side : arr) {
            int[] s = new int[]{side.a, side.b, side.c};
            Arrays.sort(s);
            set.add(s[0] + "-" + s[1] + "" + s[2]);
        }

        return set.size();
    }
}
