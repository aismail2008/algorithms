package com.code.test.concurrency;

import java.util.concurrent.Phaser;

public class PhaserTrain {

	class Worker extends Thread {
		Phaser deliveryOrder;

		Worker(Phaser order, String name) {
			deliveryOrder = order;
			this.setName(name);
			deliveryOrder.register();
			start();
		}

		public void run() {
			for (int i = 1; i <= 3; i++) {
				System.out.println("\t" + getName() + " doing his work for order no. " + i);
				if (i == 3) {
					// work completed for this delivery order, so deregister
					deliveryOrder.arriveAndDeregister();
				} else {
					deliveryOrder.arriveAndAwaitAdvance();
				}
				try {
					Thread.sleep(3000); // simulate time for preparing the food
										// item
				} catch (InterruptedException ie) {
					/* ignore exception */
					ie.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// the Phaser is the synchronizer to make food items one-by-one,
		// and deliver it before moving to the next item
		Phaser deliveryOrder = new Phaser(1);
		PhaserTrain train = new PhaserTrain();
		System.out.println("Starting to process the delivery order ");
		train.new Worker(deliveryOrder, "Cook");
		train.new Worker(deliveryOrder, "Helper");
		train.new Worker(deliveryOrder, "Attendant");
		for (int i = 1; i <= 3; i++) {
			// Prepare, mix and deliver this food item
			deliveryOrder.arriveAndAwaitAdvance();
			System.out.println("Deliver food item no. " + i);
		}
		// work completed for this delivery order, so deregister
		deliveryOrder.arriveAndDeregister();
		System.out.println("Delivery order completed... give it to the customer");
	}
}
