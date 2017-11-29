package com.code.test.problemset.Uber;

/**
 * Created by aliismail on 28/11/2017.
 */
import java.util.concurrent.Semaphore;

class RateLimiter {
    public static void actuallyCallAPI() {
        // Should not be called more often than 10 times per second.
        // This function should not be changed.
        System.out.println("Called API.");
    }

    private static int RATE = 10;
    static Semaphore limiter = new Semaphore(RATE);

    public static void callAPI() {
        if(limiter.availablePermits() == 0){
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

    public static void testRateLimiter() {
        for (int i = 0; i < 12; i++) {
            callAPI();
        }

        System.out.println("Waiting...");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < 2; i++) {
            callAPI();
        }
    }

    public static void main(String[] args) {
        testRateLimiter();
    }
}