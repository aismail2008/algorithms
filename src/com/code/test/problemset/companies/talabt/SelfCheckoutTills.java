package com.code.test.problemset.companies.talabt;

import java.util.PriorityQueue;
import java.util.Random;

/*
 *
 *     Q2: There is a queue for the self-checkout tills at the supermarket.
 *     Your task is write a function to calculate the total time required for all the customers to check out!
 *     input:
 *     ======
 *     customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
 *     n: a positive integer, the number of checkout tills.
 *     output:
 *     =======
 *     The function should return an integer, the total time required.
 *     queueTime([5,3,4], 1) // should return 12, because when there is 1 till, the total time is just the sum of the times
 *     queueTime([12,2,1,4, 3], 2) // should return 12, because here n=2 and the 2nd, 3rd, 4th and 5th people in the queue finish before the 1st person has finished.
 *
 */
public class SelfCheckoutTills {
    public static void main(String[] args) {

        System.out.println("Hello !");
    }

    /**
     * Analyzes the time and space complexity of the queueTime function.
     *
     * Time Complexity: O(n log k), where n is the number of customers and k is the number of tills.
     * - Initializing the priority queue takes O(k) time.
     * - For each customer (n times), we perform a poll and offer operation on the priority queue,
     *   each taking O(log k) time.
     * - The final loop to find the maximum time takes O(k log k) time.
     *
     * Space Complexity: O(k), where k is the number of tills.
     * - We use a priority queue that stores at most k elements (one for each till).
     * - No additional data structures are used that scale with the input size.
     *
     * @return String explaining the time and space complexity
     */
    public static int queueTime(int[] customers, int n) {
        PriorityQueue<Integer> tills = new PriorityQueue<>(n);

        // Initialize tills
        for (int i = 0; i < n; i++) {
            tills.offer(0);
        }

        // Process customers
        for (int customer : customers) {
            int leastBusyTill = tills.poll();
            tills.offer(leastBusyTill + customer);
        }

        // Find the maximum time
        int maxTime = 0;
        while (!tills.isEmpty()) {
            maxTime = tills.poll();
        }

        return maxTime;
    }
}