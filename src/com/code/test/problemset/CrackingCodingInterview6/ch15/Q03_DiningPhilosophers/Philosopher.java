package com.code.test.problemset.CrackingCodingInterview6.ch15.Q03_DiningPhilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {
    private final int maxPause = 100;
    private int bites = 10;

    private Chopstick left;
    private Chopstick right;
    private int index;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    public boolean pickUp() {
        if (!left.pickUp()) {
            return false;
        }
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }

    public void chew() {
        System.out.println("Philosopher " + index + ": eating");
    }


    public void putDown() {
        right.putDown();
        left.putDown();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public static class Chopstick {
        private Lock lock;

        public Chopstick() {
            lock = new ReentrantLock();
        }

        public boolean pickUp() {
            return lock.tryLock();
        }

        public void putDown() {
            lock.unlock();
        }
    }

}
