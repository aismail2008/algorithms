package com.code.test.concurrency.collections;

import java.util.concurrent.CountDownLatch;

/**
 * Allows threads to wait for a countdown to complete
 */
public class CountDownLatchTrain {
    static class Runner extends Thread {
        private CountDownLatch timer;

        public Runner(CountDownLatch counter, String name) {
            this.timer = counter;
            this.setName(name);
            System.out.println(this.getName() + " ready and waiting for the count down to start");
            this.start();
        }

        public void run() {
            try {
                // wait for the timer count down to reach 0
                timer.await();
            } catch (InterruptedException ie) {
                System.err.println("interrupted -- can't start running the race");
            }
            System.out.println(this.getName() + " started running");
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // assume that only two ATM machines are available in the ATM room
        CountDownLatch timer = new CountDownLatch(5);
        // list of people waiting to access the machine
        new Runner(timer, "Mickey");
        new Runner(timer, "Donald");
        new Runner(timer, "Tom");
        new Runner(timer, "Jerry");
        new Runner(timer, "Casper");

        System.out.println("Starting the countdown ");
        long countVal = timer.getCount();
        while (countVal > 0) {
            Thread.sleep(1000); // 1000 milliseconds = 1 second
            System.out.println(countVal);
            if (countVal == 1) {
                // once counter.countDown(); in the next statement is called,
                // Count down will reach zero; so shout "Start"
                System.out.println("Start");
            }
            timer.countDown(); // count down by 1 for each second
            countVal = timer.getCount();
        }
    }
}
