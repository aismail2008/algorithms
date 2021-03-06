package com.code.test.problemset.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * https://leetcode.com/problems/subsets-ii/
 */
public class Q246_SubsetsII {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        new Q246_SubsetsII().subsetsWithDup(arr);
    }

    //-------------Ali----------//
//                    ()
//        1        |     2     |        2
//    12   12(X)   |   22
//  123            |
    Set<List<Integer>> results = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(arr);

        results.add(Collections.emptyList());

        for (int i = 0; i < arr.length; i++) {
            results.add(Collections.singletonList(arr[i]));

            List<Integer> prefix = new ArrayList<>();
            prefix.add(arr[i]);
            allSets(arr, i + 1, prefix);
        }

        return results.stream().collect(Collectors.toList());
    }

    private void allSets(int[] arr, int i, List<Integer> prefix) {

        for (; i < arr.length; i++) {
            List cur = new ArrayList<>(prefix);
            cur.add(arr[i]);
            results.add(new ArrayList<>(cur));
            allSets(arr, i + 1, cur);
        }
    }
    //-------------Ali----------//

    public static class UniquePermutationsNum {

        public static void main(String[] args) {
            permutations(new int[]{1, 2,2}).forEach(l -> {
                l.forEach(i -> System.out.print(i + "-"));
                System.out.println();
            });
        }

        public static List<List<Integer>> permutations(int[] s) {
            permutations(s, new ArrayList<>());
            return permutationsList.stream().collect(Collectors.toList());
        }

        static Set<List<Integer>> permutationsList = new HashSet<>();

        public static void permutations(int[] s, List<Integer> prefix) {
            if (s.length != 0) {
                for (int i = 0; i < s.length; i++) {
                    int[] rem = copyArrayExceptI(i, s);  // swap solution as in old permutation
                    List<Integer> iPrefix = new ArrayList<>(prefix);
                    iPrefix.add(s[i]);
                    iPrefix.sort(Integer::compareTo);
                    permutationsList.add(new ArrayList<>(iPrefix));
                    permutations(rem, iPrefix);
                }
            }
        }

        private static int[] copyArrayExceptI(int i, int[] arr) {
            int[] newArr = new int[arr.length - 1];
            int h = 0;
            for (int j = 0; j < newArr.length; j++) {
                if (h == i) {
                    h++;
                }
                newArr[j] = arr[h++];
            }
            return newArr;
        }
    }
}
