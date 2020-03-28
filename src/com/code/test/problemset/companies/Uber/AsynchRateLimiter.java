package com.code.test.problemset.companies.Uber;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by aliismail on 15/12/2017.
 */
public class AsynchRateLimiter {
    private final long capacity;
    private AtomicLong size;
    private long intervalMS;

    public AsynchRateLimiter(int maxBudget, long intervalInMS) {
        this.capacity = maxBudget;
        this.size = new AtomicLong(maxBudget);
        this.intervalMS = intervalInMS;

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            long current = size.get();
            if (current < maxBudget)
                size.compareAndSet(current, current + 1);
            System.out.println(size.get());
        }, 1, intervalInMS / maxBudget, TimeUnit.MILLISECONDS);
    }

    /**
     * Attempt to consume the specified amount of resources.  If the resources
     * are available, consume them and return true; otherwise, consume nothing
     * and return false.
     */
    public boolean consume(int amount) {
        long current = size.get();
        if (current >= amount) {
            return size.compareAndSet(current, current - amount);
        }
        return false;
    }

    public static void main(String[] args) {
        AsynchRateLimiter r = new AsynchRateLimiter(10, 1000);
        for (int i = 0; i < 12; i++) {
            if (r.consume(1))
                System.out.println("Call API.");
            else
                System.out.println("Did not call API.");
        }

        System.out.println("Waiting...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < 2; i++) {
            if (r.consume(1))
                System.out.println("Call API.");
            else
                System.out.println("Did not call API.");
        }
    }

    //------------------------------------//
    class RateLimiter {
        private final double fillRatePerMs;
        private final double maxBudget;
        private double currentBudget;
        private long lastUpdateTime;

        public RateLimiter(double maxBudget, double fillRatePerMs) {
            this.fillRatePerMs = fillRatePerMs;
            this.maxBudget = maxBudget;
            this.currentBudget = maxBudget;
            this.lastUpdateTime = System.currentTimeMillis();
        }

        /**
         * Attempt to consume the specified amount of resources.  If the resources
         * are available, consume them and return true; otherwise, consume nothing
         * and return false.
         */
        public synchronized boolean consume(double amount) {
            long msSinceLastUpdate = System.currentTimeMillis() - lastUpdateTime;
            currentBudget = Math.min(maxBudget, currentBudget + msSinceLastUpdate * fillRatePerMs);
            lastUpdateTime += msSinceLastUpdate;

            if (currentBudget >= amount) {
                currentBudget -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

}
