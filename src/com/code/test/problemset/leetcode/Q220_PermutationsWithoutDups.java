package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Permutations without Dups:
 * Write a method to compute all permutations of a string of unique characters.
 *
 * O(n2*!n) time
 * space (n)
 * <p>
 * https://leetcode.com/problems/permutations/
 *
 *
 * TIme : O(N * n-1 * n-2 * .. * 1) = O(N!)
 */
public class Q220_PermutationsWithoutDups {
    public static class UniquePermutationsStr {

        public static void main(String[] args) {
            permutations("aebc").forEach(System.out::println);
        }

        public static List<String> permutations(String s) {
            permutations(s, "");
            return permutationsList.stream().collect(Collectors.toList());
        }

        static Set<String> permutationsList = new HashSet<>();

        public static void permutations(String s, String prefix) {
            if (s.length() == 0) {
                permutationsList.add(prefix);
            } else {
                for (int i = 0; i < s.length(); i++) {
                    String rem = s.substring(0, i) + s.substring(i + 1);
                    permutations(rem, prefix + s.charAt(i));
                }
            }
        }
    }

    public static class UniquePermutationsNum {

        public static void main(String[] args) {
            permutations(new int[]{1, 2, 3}).forEach(l -> {
                l.forEach(i -> System.out.print(i + "-"));
                System.out.println();
            });
        }

        public static List<List<Integer>> permutations(int[] s) {
            permutations(s, 0, new ArrayList<>());
            return permutationsList.stream().collect(Collectors.toList());
        }

        static Set<List<Integer>> permutationsList = new HashSet<>();

        public static void permutations(int[] s, int start, List<Integer> prefix) {
            if (start == s.length) {
                permutationsList.add(prefix);
            } else {
                for (int i = start; i < s.length; i++) {
                    List<Integer> iPrefix = new ArrayList<>(prefix);
                    iPrefix.add(s[i]);
                    swap(s, start, i);
                    permutations(s, start + 1, iPrefix);
                    swap(s, i, start);
                }
            }
        }

        static private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
