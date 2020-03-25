package com.code.test.concurrency.blockingqueue;

import java.util.concurrent.*;


//** All Blocking Queues are thread safe
public class BlockingQueueTrain {
    private static BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

    static class TakeThread extends Thread {
        public void run() {
            try {
                // use take() instead of remove()
                // note that take() blocks, whereas remove() doesn't block
                System.out.println("The removed element is: " + priorityBlockingQueue.take());
            } catch (InterruptedException ie) {
                // its safe to ignore this exception
                ie.printStackTrace();
            }
        }
    }

	static class PutThread extends Thread {
        public void run () {
            try {
                // use take() instead of remove()
                // note that take() blocks, whereas remove() doesn't block
                priorityBlockingQueue.put(10);
                System.out.println("The element added succefully");
            } catch (InterruptedException ie) {
                // its safe to ignore this exception
                ie.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        priorityQueue();
		new TakeThread().start();
		new PutThread().start();

        //-------------------------------------------//
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(3);
        arrayBlockingQueue.add(1);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);

        try {
            arrayBlockingQueue.add(2);
        } catch (IllegalStateException e1) {
            e1.printStackTrace();
        }
        //-------------------------------------------//
        BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
        BlockingQueue<String> bounded = new LinkedBlockingQueue<String>(1024);
        //-------------------------------------------//
        /**
         * Elements must implement Delayed Interface
         */
        BlockingQueue<Delayed> queue = new DelayQueue<Delayed>();
        Delayed element1 = new Delayed() {
            public int compareTo(Delayed o) {
                // TODO Auto-generated method stub
                return 0;
            }

            public long getDelay(TimeUnit unit) {
                // TODO Auto-generated method stub
                return 0;
            }
        };

        try {
            queue.put(element1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Delayed element2 = queue.take();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //-------------------------------------------//


		LinkedBlockingDeque<Integer> blockingDequeue = new LinkedBlockingDeque<>();
    }

    private static void priorityQueue() {
        /**
         * Elements must implement Comparable Interface
         */
        BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(3);

        priorityBlockingQueue.add(2);
        priorityBlockingQueue.add(5);
        priorityBlockingQueue.add(7);
        priorityBlockingQueue.add(3);
        priorityBlockingQueue.offer(1);
        priorityBlockingQueue.offer(5);
        try {
            priorityBlockingQueue.put(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Just loop on internal array with no sort
        priorityBlockingQueue.stream().forEach(s -> System.out.println(s));

        System.out.println("=====");

        // Get data sorted
        while (priorityBlockingQueue.size() > 0) {
            System.out.println(priorityBlockingQueue.remove());
        }
    }
}
