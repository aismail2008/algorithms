package com.code.test.concurrency.collections;

import java.util.concurrent.Semaphore;

public class SemaphoreTrain {
	class Person extends Thread {
		private Semaphore machines;

		public Person(Semaphore machines, String name) {
			this.machines = machines;
			this.setName(name);
			this.start();
		}

		public void run() {
			try {
				System.out.println(getName() + " waiting to access an ATM machine");
				machines.acquire();
				System.out.println(getName() + " is accessing an ATM machine");
				Thread.sleep(1000); // simulate the time required for
									// withdrawing amount
				System.out.println(getName() + " is done using the ATM machine");
				machines.release();
			} catch (InterruptedException ie) {
				System.err.println(ie);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// assume that only two ATM machines are available in the ATM room
		Semaphore machines = new Semaphore(2);
		SemaphoreTrain train = new SemaphoreTrain();
		// list of people waiting to access the machine
		train.new Person(machines, "Mickey");
		train.new Person(machines, "Donald");
		train.new Person(machines, "Tom");
		train.new Person(machines, "Jerry");
		train.new Person(machines, "Casper");
	}
}
