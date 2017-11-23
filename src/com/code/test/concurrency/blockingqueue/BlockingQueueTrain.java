package com.code.test.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTrain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Elements must implement Comparable Interface
		 */
		final BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<Integer>();
		//-------------------------------------------//
		final BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(2);
		arrayBlockingQueue.add(1);
		try {
			arrayBlockingQueue.put(2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//-------------------------------------------//
		BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
		BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);
		//-------------------------------------------//
		/**
		 * Elements must implement Delayed Interface
		 */
		BlockingQueue<Delayed> queue = new DelayQueue<Delayed>();
        Delayed element1 = new Delayed(){
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
		
		
		new Thread() {
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
		}.start();
		
		
		new Thread() {
			public void run() {
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
		}.start();
	}
}
