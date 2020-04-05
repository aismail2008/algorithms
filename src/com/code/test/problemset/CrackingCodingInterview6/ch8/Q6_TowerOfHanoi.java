package com.code.test.problemset.CrackingCodingInterview6.ch8;

import java.util.Stack;

/**
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using Stacks.
 */
public class Q6_TowerOfHanoi {

    // Java recursive function to solve tower of hanoi puzzle
    static void towerOfHanoi(int n, Stack<Integer> A, Stack<Integer> C, Stack<Integer> B) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + A + " to rod " + C);
            C.push(A.pop());
            return;
        }
        towerOfHanoi(n - 1, A, B, C);
        C.push(A.pop());
        System.out.println("Move disk " + n + " from A to C");
        towerOfHanoi(n - 1, B, C, A);
    }

    //  Driver method
    public static void main(String args[]) {

        Stack<Integer> A = new Stack();
        Stack<Integer> B = new Stack();
        Stack<Integer> C = new Stack();
        /* Load up tower */
        int numberOfDisks = 5;
        for (int disk = numberOfDisks - 1; disk > 0; disk--) {
            A.add(disk);
        }
        int n = 4; // Number of disks
        towerOfHanoi(n, A, C, B);  // A, B and C are names of rods
        C.forEach(System.out::println);
    }


    static class Tower {
        private Stack<Integer> disks = new Stack<Integer>();
        public String name;

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }

        public void print() {
            System.out.println("Contents of Tower " + name + ": " + disks.toString());
        }

        public void moveDisks(int quantity, Tower destination, Tower buffer) {
            if (quantity <= 0) return;

            moveDisks(quantity - 1, buffer, destination);
            System.out.println("Move " + disks.peek() + " from " + this.name + " to " + destination.name);
            moveTopTo(destination);
            buffer.moveDisks(quantity - 1, destination, this);
        }
    }
}
