package com.code.test.concurrency.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerExample {

	public static PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>(2);
	
	public class Producer extends Thread{
		PriorityBlockingQueue<Integer> queue;
		public Producer(PriorityBlockingQueue<Integer> queue){
			this.queue = queue;
		}
		
		public void run(){
			queue.put(ThreadLocalRandom.current().nextInt());
			queue.put(ThreadLocalRandom.current().nextInt());
			queue.put(ThreadLocalRandom.current().nextInt());
			queue.put(ThreadLocalRandom.current().nextInt());
		}
	}
	
	public class Consumer extends Thread{
		PriorityBlockingQueue<Integer> queue;
		public Consumer(PriorityBlockingQueue<Integer> queue){
			this.queue = queue;
		}
		
		public void run(){
			try {
				System.out.println(queue.take() + "");
				System.out.println(queue.take() + "");
				System.out.println(queue.take() + "");
				System.out.println(queue.take() + "");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumerExample procon = new ProducerConsumerExample();
		
		procon.new Consumer(queue).start();
		procon.new Producer(queue).start();
	}

}
