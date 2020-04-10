package com.code.test.problemset.CrackingCodingInterview6.ch15.Q03_DiningPhilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherHigherPriority extends Thread {
    private final int maxPause = 100;
    private int bites = 10;

    private Chopstick lower;
    private Chopstick higher;
    private int index;

    public PhilosopherHigherPriority(int i, Chopstick left, Chopstick right) {
        index = i;
        if (left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        } else {
            this.lower = right;
            this.higher = left;
        }
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    public void pickUp() {
        lower.pickUp();
        higher.pickUp();
    }

    public void chew() {
        System.out.println("Philosopher " + index + ": eating");
    }

    public void putDown() {
        higher.putDown();
        lower.putDown();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    static class Chopstick {
        private Lock lock;
        private int number;

        public Chopstick(int n) {
            lock = new ReentrantLock();
            this.number = n;
        }

        public void pickUp() {
            lock.lock();
        }

        public void putDown() {
            lock.unlock();
        }

        public int getNumber() {
            return number;
        }
    }
}
