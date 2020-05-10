package com.code.test.problemset.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q78_MergeKSortedArrays {
    static class SolutionA {
        // O(M * N): m is number of arrays and N is max length of all arrays
        public static int[] mergeKSortedArray(int[][] arr) {
            if (arr == null || arr.length == 0) {
                return new int[]{};
            }

            int[] indices = new int[arr.length];
            int total = Arrays.stream(arr).map(a -> a.length).reduce((a, b) -> a + b).get();
            int[] output = new int[total];

            while (total > 0) {
                int min = Integer.MAX_VALUE;
                int minInd = -1;
                for (int i = 0; i < arr.length; i++) {
                    int j = indices[i];
                    if (j >= arr[i].length) {
                        continue;// we consumed all this array
                    }

                    int val = arr[i][j];
                    if (val < min) {
                        min = val;
                        minInd = i;
                    }
                }
                output[output.length - total] = arr[minInd][indices[minInd]];
                indices[minInd]++;
                total--;
            }

            return output;
        }
    }

    static class SolutionB {
        /**
         * This problem can be solved by using a heap. The time complexity is O(nlog(k)), where n is the total number of elements and k is the number of arrays.
         * It takes O(log(k)) to insert an element to the heap and it takes O(log(k)) to delete the minimum element.
         */
        static class ArrayContainer implements Comparable<ArrayContainer> {
            int[] arr;
            int index;

            public ArrayContainer(int[] arr, int index) {
                this.arr = arr;
                this.index = index;
            }

            @Override
            public int compareTo(ArrayContainer o) {
                return this.arr[this.index] - o.arr[o.index];
            }
        }

        public static int[] mergeKSortedArray(int[][] arr) {
            PriorityQueue<ArrayContainer> queue = new PriorityQueue<>();
            int total = 0;

            //add arrays to heap
            for (int i = 0; i < arr.length; i++) {
                queue.add(new ArrayContainer(arr[i], 0));
                total = total + arr[i].length;
            }

            int m = 0;
            int result[] = new int[total];

            //while heap is not empty
            while (!queue.isEmpty()) {
                ArrayContainer ac = queue.poll();
                result[m++] = ac.arr[ac.index];

                if (ac.index < ac.arr.length - 1) {
                    ac.index++;
                    queue.add(ac);
                }
            }

            return result;
        }

    }
}
