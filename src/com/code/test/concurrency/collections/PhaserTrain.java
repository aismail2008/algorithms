package com.code.test.concurrency.collections;

import java.util.concurrent.Phaser;

/**
 * Phaser is used to support a synchronization barrier
 */
public class PhaserTrain {

	static class Worker extends Thread {
		Phaser deliveryOrder;

		Worker(Phaser order, String name) {
			deliveryOrder = order;
			this.setName(name);
			deliveryOrder.register();
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

		System.out.println("Starting to process the delivery order ");

		new Worker(deliveryOrder, "Cook").start();
		new Worker(deliveryOrder, "Helper").start();
		new Worker(deliveryOrder, "Attendant").start();

		for (int i = 1; i <= 3; i++) {
			// Prepare, mix and deliver this food item
			deliveryOrder.arriveAndAwaitAdvance();
			System.out.println("Deliver food item no. " + deliveryOrder.getPhase());
		}
		// work completed for this delivery order, so deregister
		deliveryOrder.arriveAndDeregister();
		System.out.println("Delivery order completed... give it to the customer");
	}
}
