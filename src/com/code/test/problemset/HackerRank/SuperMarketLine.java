package com.code.test.problemset.HackerRank;

import java.util.*;

/**
 *
 * A supermarket has many customers entering and exiting at various points. They want to keep track of customers and get notification when a customer leaves the store. There are number of checkout lines, where customers with basket of items queue to pay and exit the store. Individual checkout lines and customers are assigned numerical IDs. As happens in life, sometimes customers want to add more items to their baskets and sometimes they realize that they don't need certain items they picked up earlier and remove them from the basket. To enforce checkout priorities a few rules have been implemented in the supermarket:
 *
 * • A customer cannot switch the lines before exit once they join a given checkout line
 *
 * • If a customer increases their items to purchase, they must go to the back of the same line.
 *
 * • If a customer removes items from their basket, they will keep their position in the line (or leave the store if they don't have any more items).
 *
 * A customer will leave the supermarket as soon as they have no items left to checkout. Note that the lines with smaller IDs are closer to the exit, so if two customers pass the checkout line at the same time, the one closer to the exit would leave the store first.
 *
 * Problem Statement
 *
 * You will receive the stream of N instructions. Each instruction can be one of the following actions:
 *
 * • CustomerEnter - indicates that a customer joined a checkout line. Attributes: Customerld, LineNumber and NumItems.
 *
 * • BasketChange - indicates that a customer changed number their basket. Attributes: Customerld and NewNumitems.
 *
 * • LineService - indicates that several items have been processed in the line. Attributes: LineNumber and NumProcessedItems.
 *
 * • LinesService - indicates that one item has been processed in every line Sog (if there are k lines then in total kitems are processed).
 *
 * Important Notes:
 *
 * • The NewNumItems attribute of the BasketChange action is the number of total items.
 *
 * • Line service calls with no queue in the line should be ignored.
 *
 * Your task is to keep track of customers and notify when a customer leaves the store.
 *
 *
 * Constraints
 *
 * • 0 ≤ N, Customerld, LineNumber < 2^32
 *
 * • 0 ≤ NumItems, NewNumItems, NumProcessedItems ≤ 10^3
 *
 *
 * • It is guaranteed that BasketChange will only happen for the customers who are still in the store.
 *
 *
 * Input Format For Custom Testing
 *
 * Input to the program is specified using a simple text format. The format and details of parsing are not relevant to answering the question but custom input can be used to help with development and debugging. The first line of input contains an integer N that denotes the number of instructions. Each of the N subsequent lines contains one of the instructions as in the format below: H
 *
 * • CustomerEnter <CustomerId> <LineNumber> <Numltems>
 *
 * • BasketChange <CustomerId> <NewNumltems>
 *
 * • LineService <LineNumber> <NumProcessedItems>
 *
 * . LinesService
 *
 * Some example inputs and outputs are described below.
 *
 * Sample Case 0
 *
 *
 * Sample input for custom testing:
 * 5
 * CustomerEnter 123 1 5
 * CustomerEnter 2 2 3
 * LinesService
 * CustomerEnter 3 1 2
 * LineService 1 6
 *
 * Expected output:
 * 123
 * 3
 *
 * Explanation:
 *
 * There are 2 customers (123 and 2) queued on two lines (1 and 2). When first LinesService is called on both lines, both queued customers still have some items to check out. Namely, customer 123 has still 4 items, and customer 2 has 2 items to checkout. Then customer 3 joins to the 1st line. After next LineService on the 1st line, both customers with 123 and 3 IDs are checked out (first 123, and then 3). Customer 2 is still in the line.
 *
 * Sample Case 1
 *
 * Sample input for custom testing:
 * 5
 * CustomerEnter A 1 5
 * CustomerEnter B 1 2
 * LinesService 1 4
 * BasketChange A 6
 * LineService 1 5
 *
 * Expected output:
 * 3
 * 123
 *
 * Explanation:
 *
 * Upon first LineService 4 out of 5 items of customer 123 are processed. However, customer then increases the number of items in their basket (namely adds 1 extra item), this puts them at the back of the line. During the next LineService call customer 3 is checked out first, and customer 123 is checked out next (as they only had 2 items left to process).
 *
 * --------
 * Main class to handle supermarket customer checkout simulation.
 *
 * Time Complexity: O(N * max(n, m, k log k))
 * - N: number of instructions
 * - n: max customers in a line
 * - m: max items processed in one operation
 * - k: number of lines
 * Worst case: O(N * n) if basket changes dominate
 *
 * Space Complexity: O(k + n)
 * - k: number of lines
 * - n: total number of customers
 * In practice, often simplifies to O(n) for space if k << n.
 */
public class SuperMarketLine {
    private static Map<Long, Queue<Customer>> lines = new HashMap<>();
    private static Map<Long, Customer> customers = new HashMap<>();

    /**
     * Represents a customer in the supermarket.
     */
    static class Customer {
        long id;
        long lineNumber;
        long items;
        long originalItems;

        /**
         * Constructs a new Customer.
         *
         * @param id         The customer's unique identifier.
         * @param lineNumber The checkout line number the customer is in.
         * @param items      The number of items in the customer's basket.
         */
        Customer(long id, long lineNumber, long items) {
            this.id = id;
            this.lineNumber = lineNumber;
            this.items = items;
            this.originalItems = items;
        }
    }

    /**
     * Handles a customer entering the supermarket and joining a checkout line.
     *
     * @param customerId The unique identifier of the customer.
     * @param lineNumber The checkout line number the customer is joining.
     * @param numItems   The number of items in the customer's basket.
     */
    private static void customerEnter(long customerId, long lineNumber, long numItems) {
        Customer customer = new Customer(customerId, lineNumber, numItems);
        customers.put(customerId, customer);
        lines.computeIfAbsent(lineNumber, k -> new LinkedList<>()).offer(customer);
    }

    /**
     * Handles changes to a customer's basket.
     *
     * @param customerId  The unique identifier of the customer.
     * @param newNumItems The new number of items in the customer's basket.
     */
    private static void basketChange(long customerId, long newNumItems) {
        Customer customer = customers.get(customerId);

        if (customer != null) {
            Queue<Customer> line = lines.get(customer.lineNumber);
            if (newNumItems > customer.originalItems) {
                // Move to the back of the line
                line.remove(customer);
                customer.items += newNumItems - customer.originalItems;
                customer.originalItems = customer.items;
                line.offer(customer);
            } else if (newNumItems < customer.originalItems) {
                customer.items = Math.min(customer.items, newNumItems);
                customer.originalItems = customer.items;
                // Check if the customer should exit after removing items
                if (newNumItems == 0) {
                    line.remove(customer);
                    processCustomerExit(customer);
                }
            }
        }
    }

    /**
     * Processes items for a specific checkout line.
     *
     * @param lineNumber        The number of the line to process.
     * @param numProcessedItems The number of items to process.
     */
    private static void lineService(long lineNumber, long numProcessedItems) {
        Queue<Customer> line = lines.get(lineNumber);
        if (line != null && !line.isEmpty()) {
            while (numProcessedItems > 0 && !line.isEmpty()) {
                Customer customer = line.peek();
                if (customer.items <= numProcessedItems) {
                    numProcessedItems -= customer.items;
                    line.poll();
                    processCustomerExit(customer);
                } else {
                    customer.items -= numProcessedItems;
                    break;
                }
            }
        }
    }

    /**
     * Processes one item for each checkout line.
     */
    private static void linesService() {
        int lineSize = lines.size();
        for (int i = 0; i < lineSize; i++) {
            lineService(i+1, 1);
        }
    }

    /**
     * Processes items for a single checkout line.
     *
     * @param line              The queue of customers in the line.
     * @param numProcessedItems The number of items to process.
     */
    private static void processLine(Queue<Customer> line, long numProcessedItems) {
        long remainingItems = numProcessedItems;
        while (!line.isEmpty() && remainingItems > 0) {
            Customer customer = line.peek();
            if (customer.items <= remainingItems) {
                remainingItems -= customer.items;
                line.poll();
                processCustomerExit(customer);
            } else {
                customer.items -= remainingItems;
                break;
            }
        }
    }

    /**
     * Handles a customer exiting the supermarket.
     *
     * @param customer The customer who is exiting.
     */
    private static void processCustomerExit(Customer customer) {
        System.out.println(customer.id);
        customers.remove(customer.id);
    }

    /**
     * Main method to run the supermarket simulation.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        scanner.nextLine();

        for (long i = 0; i < N; ++i) {
            String[] instruction = scanner.nextLine().split(" ");
            String instructionType = instruction[0];

            if (instructionType.equals("CustomerEnter")) {
                long customerId = Long.parseLong(instruction[1]);
                long lineNumber = Long.parseLong(instruction[2]);
                long numItems = Long.parseLong(instruction[3]);
                customerEnter(customerId, lineNumber, numItems);
            } else if (instructionType.equals("BasketChange")) {
                long customerId = Long.parseLong(instruction[1]);
                long newNumItems = Long.parseLong(instruction[2]);
                basketChange(customerId, newNumItems);
            } else if (instructionType.equals("LinesService")) {
                long lineNumber = Long.parseLong(instruction[1]);
                long numProcessedItems = Long.parseLong(instruction[2]);
                lineService(lineNumber, numProcessedItems);
            } else if (instructionType.equals("LineService")) {
                linesService();
            } else {
                System.out.println("Malformed input!");
                System.exit(-1);
            }
        }
    }
}