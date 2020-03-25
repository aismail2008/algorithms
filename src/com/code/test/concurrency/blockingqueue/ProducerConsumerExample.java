package com.code.test.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerExample {

    public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2);

    static class Producer extends Thread {
        BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.put(ThreadLocalRandom.current().nextInt());
                queue.put(ThreadLocalRandom.current().nextInt());
                queue.put(ThreadLocalRandom.current().nextInt());
                queue.put(ThreadLocalRandom.current().nextInt());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                System.out.println(queue.take() + "");
                System.out.println(queue.take() + "");
                System.out.println(queue.take() + "");
                System.out.println(queue.take() + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Consumer(queue).start();
        new Producer(queue).start();
    }
}
