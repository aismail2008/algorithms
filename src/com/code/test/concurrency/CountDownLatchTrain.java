package com.code.test.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTrain {
	class Runner extends Thread {
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
		CountDownLatchTrain train = new CountDownLatchTrain();
		// list of people waiting to access the machine
		train.new Runner(timer, "Mickey");
		train.new Runner(timer, "Donald");
		train.new Runner(timer, "Tom");
		train.new Runner(timer, "Jerry");
		train.new Runner(timer, "Casper");

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
