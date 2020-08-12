package com.code.test.concurrency.collections;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Ex: Waiting for whole party to arrive to start the game
 */
public class CyclicBarrierTrain {
	static class MixedDoubleTennisGame extends Thread {
		public void run() {
				System.out.println("All four players ready, gme stats ...");
		}
	}

	static class Player extends Thread {
		private CyclicBarrier waitPoint;

		public Player(CyclicBarrier waitPoint, String name) {
			this.waitPoint = waitPoint;
			this.setName(name);
		}
		
		
		public void run() {
			try {
				System.out.println("Player : "  + getName() + " ready !!");
				waitPoint.await();
			} catch (InterruptedException ie) {
				System.err.println("Got interrupted");
			} catch (BrokenBarrierException ie) {
				System.err.println("Got interrupted");
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// assume that only two ATM machines are available in the ATM room

		CyclicBarrier waitPoint = new CyclicBarrier(4, new MixedDoubleTennisGame());
		// list of people waiting to access the machine
		new Player(waitPoint, "Ali").start();
		new Player(waitPoint, "Alaa").start();
		new Player(waitPoint, "Dora").start();
		new Player(waitPoint, "Tintin").start();
	}
}
