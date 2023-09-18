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
                int temp = ThreadLocalRandom.current().nextInt();
                queue.put(temp);
                System.out.println(temp + " added");
                temp = ThreadLocalRandom.current().nextInt();
                queue.put(temp);
                System.out.println(temp + " added");
                temp = ThreadLocalRandom.current().nextInt();
                queue.put(temp);
                System.out.println(temp + " added");
                temp = ThreadLocalRandom.current().nextInt();
                queue.put(temp);
                System.out.println(temp + " added");
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
                System.out.println(queue.take() + " consumed");
                System.out.println(queue.take() + " consumed");
                System.out.println(queue.take() + " consumed");
                System.out.println(queue.take() + " consumed");
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
