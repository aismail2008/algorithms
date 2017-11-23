package com.code.test.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTrain {
	class MixedDoubleTennisGame extends Thread {
		public void run() {
				System.out.println("All four players ready, gme stats ...");
		}
	}
	
	class Player extends Thread {
		private CyclicBarrier waitPoint;

		public Player(CyclicBarrier waitPoint, String name) {
			this.waitPoint = waitPoint;
			this.setName(name);
			this.start();
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
		CyclicBarrierTrain train = new CyclicBarrierTrain();
		
		CyclicBarrier waitPoint = new CyclicBarrier(4, train.new MixedDoubleTennisGame());
		// list of people waiting to play tennis
		train.new Player(waitPoint, "Ali");
		train.new Player(waitPoint, "Alaa");
		train.new Player(waitPoint, "Dora");
		train.new Player(waitPoint, "Tintin");
	}
}
