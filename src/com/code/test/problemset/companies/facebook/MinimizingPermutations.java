package com.code.test.problemset.companies.facebook;

/**
 * Minimizing Permutations
 * In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as (a_1, a_2, ..., a_N).
 * You want to rearrange the elements of the permutation into increasing order, repeatedly making the following operation:
 * Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
 * Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.
 * Signature
 * int minOperations(int[] arr)
 * Input
 * Size N is between 1 and 8
 * Array arr is a permutation of all integers from 1 to N
 * Output
 * An integer denoting the minimum number of operations required to arrange the permutation in increasing order
 * Example
 * If N = 3, and P = (3, 1, 2), we can do the following operations:
 * Select (1, 2) and reverse it: P = (3, 2, 1).
 * Select (3, 2, 1) and reverse it: P = (1, 2, 3).
 * output = 2
 *
 */
public class MinimizingPermutations {

    /*
    add first permutaion to queue q
    while q is not empty
      pop current permutation
      for each i = 0 --> n
         for each j = 1  --> n
             swap (i to j)
             if visited that permutation before skip
             else
               add to hashMap
             check if if it's target
                then return
             else
                add to queue like BFS
     */

    int minOperations(int[] arr) {
//        3,1,2
// 1,3,2  2,1,3  3,2,1
//        1,2,3
        return 0;
    }

}
