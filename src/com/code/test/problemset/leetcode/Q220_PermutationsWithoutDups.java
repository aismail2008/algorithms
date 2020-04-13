package com.code.test.problemset.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Permutations without Dups:
 * Write a method to compute all permutations of a string of unique characters.
 * <p>
 * https://leetcode.com/problems/permutations/
 */
public class Q220_PermutationsWithoutDups {
    public List<String> perm = new ArrayList<>();

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
            permutations(s, new ArrayList<>());
            return permutationsList.stream().collect(Collectors.toList());
        }

        static Set<List<Integer>> permutationsList = new HashSet<>();

        public static void permutations(int[] s, List<Integer> prefix) {
            if (s.length == 0) {
                permutationsList.add(prefix);
            } else {
                for (int i = 0; i < s.length; i++) {
                    int[] rem = copyArrayExceptI(i, s);
                    List<Integer> iPrefix = new ArrayList<>(prefix);
                    iPrefix.add(s[i]);
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
