package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Russian Doll Envelopes
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * https://leetcode.com/problems/russian-doll-envelopes
 *
 */
@Hard
public class Q48_RussianDollEnvelopes {

    public static void main(String[] args) {
        int cnt = new Q48_RussianDollEnvelopes().maxEnvelopes(new int[][]{
                {2, 100}, {3, 200}, {4, 300}, {5, 250}, {5, 400}, {5, 500}, {6, 360}, {6, 370}, {7, 380}
        });

        System.out.println(cnt);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        int max = 1;
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    /**
    * Optimized with Binary Search and convert it to
    * We can sort the envelopes by height in ascending order and width in descending order.
    * Then look at the width and find the {@link com.code.test.problemset.leetcode.Q46_LongestIncreasingSubSequence}.
    * This problem is then converted to the problem of finding
    */
    public int maxEnvelopes_2(int[][] envelopes) {
        Comparator c = Comparator.comparing((int[] arr) -> arr[0])
                .thenComparing((int[] arr) -> arr[1], Comparator.reverseOrder());
        Arrays.sort(envelopes, c);

        ArrayList<Integer> list = new ArrayList<>();

        for(int[] arr: envelopes){
            int target = arr[1];

            if(list.isEmpty()||target>list.get(list.size()-1)){
                list.add(target);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int m = i + (j-i)/2;
                    if(list.get(m)>=target){
                        j = m;
                    }else{
                        i = m+1;
                    }
                }

                list.set(j, target);
            }
        }

        return list.size();
    }
}
