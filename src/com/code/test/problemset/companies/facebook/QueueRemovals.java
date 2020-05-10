package com.code.test.problemset.companies.facebook;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Queue Removals
 * You're given a list of n integers arr, which represent elements in a queue (in order from front to back). You're also given an integer x, and must perform x iterations of the following 3-step process:
 * Pop x elements from the front of queue (or, if it contains fewer than x elements, pop all of them)
 * Of the elements that were popped, find the one with the largest value (if there are multiple such elements, take the one which had been popped the earliest), and remove it
 * For each one of the remaining elements that were popped (in the order they had been popped), decrement its value by 1 if it's positive (otherwise, if its value is 0, then it's left unchanged), and then push it back onto the queue
 * Compute a list of x integers output, the ith of which is the 1-based index in the original array of the element which had been removed in step 2 during the ith iteration.
 * Signature
 * int[] findPositions(int[] arr, int x)
 * Input
 * x is in the range [1, 316].
 * n is in the range [x, x*x].
 * Each value arr[i] is in the range [1, x].
 * Output
 * Return a list of x integers output, as described above.
 * Example
 * n = 6
 * arr = [1, 2, 2, 3, 4, 5]
 * x = 5
 * output = [5, 6, 4, 1, 2]
 * The initial queue is [1, 2, 2, 3, 4, 5] (from front to back).
 * In the first iteration, the first 5 elements are popped off the queue, leaving just [5]. Of the popped elements, the largest one is the 4, which was at index 5 in the original array. The remaining elements are then decremented and pushed back onto the queue, whose contents are then [5, 0, 1, 1, 2].
 * In the second iteration, all 5 elements are popped off the queue. The largest one is the 5, which was at index 6 in the original array. The remaining elements are then decremented (aside from the 0) and pushed back onto the queue, whose contents are then [0, 0, 0, 1].
 * In the third iteration, all 4 elements are popped off the queue. The largest one is the 1, which had the initial value of 3 at index 4 in the original array. The remaining elements are pushed back onto the queue, whose contents are then [0, 0, 0].
 * In the fourth iteration, all 3 elements are popped off the queue. Since they all have an equal value, we remove the one that was popped first, which had the initial value of 1 at index 1 in the original array. The remaining elements are pushed backed onto the queue, whose contents are then [0, 0].
 * In the final iteration, both elements are popped off the queue. We remove the one that was popped first, which had the initial value of 2 at index 2 in the original array.
 */
public class QueueRemovals {
    public static void main(String[] args) {
        findPositions(new int[]{1, 2, 2, 3, 4, 5}, 5);
        findPositions(new int[]{2,4,2,4,3,1,2,2,3,4,3,4,4}, 4); // expected : 2,5,,10,13 but don't understand why!!
    }

    static class Val {
        int v;
        int i;

        public Val(int v, int i) {
            this.v = v;
            this.i = i;
        }
    }

    static int[] findPositions(int[] arr, int x) {
        int[] output = new int[x];
        int j = 0;
        Queue<Val> queueVal = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queueVal.offer(new Val(arr[i], i + 1));
        }

        while (!queueVal.isEmpty() && x > 0) {
            // poll popN or less element
            int popN = x;
            List<Val> l = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            int maxListIndex = Integer.MIN_VALUE;
            int i = 0;
            while (!queueVal.isEmpty() && popN > 0) {
                Val val = queueVal.poll();
                l.add(val);

                if (max < val.v || (max == val.v && l.get(maxListIndex).i > val.i)) {
                    max = val.v;
                    maxListIndex = i;
                }
                i++;
                popN--;
            }

            if (l.size() == 0) {
                break;
            }

            //Remove earliest largest number and store its index
            Val largest = l.remove(maxListIndex);
            output[j++] = largest.i;

            // decrement list and push to queue
            for (i = 0; i < l.size(); i++) {
                Val v = l.get(i);
                v.v--;
                v.v = Math.max(0, v.v);
                queueVal.offer(v);
            }

            x--;
        }

        return output;
    }
}