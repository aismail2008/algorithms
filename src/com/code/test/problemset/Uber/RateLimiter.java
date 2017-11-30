package com.code.test.problemset.Uber;

/**
 * Created by aliismail on 28/11/2017.
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class RateLimiter {
    public static void actuallyCallAPI() {
        // Should not be called more often than 10 times per second.
        // This function should not be changed.
        System.out.println("Called API.");
    }

    private static int RATE = 10;
    static Semaphore limiter = new Semaphore(RATE);

    public static void callAPI() {
        if (limiter.availablePermits() == 0) {
            // If we drop the call, let's just display:
            System.out.println("Did not call API.");
            return;
        }

        try {
            limiter.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actuallyCallAPI();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    limiter.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void callAPI2() {
        SimpleRateLimiter limiter = SimpleRateLimiter.create(10, TimeUnit.SECONDS);

        if(!limiter.tryAcquire()){
            // If we drop the call, let's just display:
            System.out.println("Did not call API.");
            return;
        }
        actuallyCallAPI();
    }

    public static void testRateLimiter() {
        for (int i = 0; i < 12; i++) {
            callAPI2();
        }

        System.out.println("Waiting...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < 2; i++) {
            callAPI();
        }
    }

    public static void main(String[] args) {
        testRateLimiter();
    }


    public static class SimpleRateLimiter {
        private Semaphore semaphore;
        private int maxPermits;
        private TimeUnit timePeriod;
        private ScheduledExecutorService scheduler;
        private static SimpleRateLimiter limiter;

        private SimpleRateLimiter(int permits, TimeUnit timePeriod) {
            this.semaphore = new Semaphore(permits);
            this.maxPermits = permits;
            this.timePeriod = timePeriod;
        }

        public static SimpleRateLimiter create(int permits, TimeUnit timePeriod) {
            synchronized (SimpleRateLimiter.class) {
                if (limiter == null) {
                    limiter = new SimpleRateLimiter(permits, timePeriod);
                    limiter.schedulePermitReplenishment();
                }
                return limiter;
            }
        }

        public boolean tryAcquire() {
            return semaphore.tryAcquire();
        }

        public void stop() {
            scheduler.shutdownNow();
        }

        public void schedulePermitReplenishment() {
            scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                semaphore.release(maxPermits - semaphore.availablePermits());
            }, 1, 1, timePeriod);

        }
    }

}