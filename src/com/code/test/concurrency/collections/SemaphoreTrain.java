package com.code.test.concurrency.collections;

import java.util.concurrent.Semaphore;

/**
 * Semaphore: controls access to one or more shared resources
 */
public class SemaphoreTrain {
	private static Semaphore machines;

	static class Person extends Thread {
		public Person(Semaphore machines, String name) {
			this.setName(name);
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
		machines = new Semaphore(2);
		// list of people waiting to access the machine
		new Person(machines, "Mickey").start();
		new Person(machines, "Donald").start();
		new Person(machines, "Tom").start();
		new Person(machines, "Jerry").start();
		new Person(machines, "Casper").start();
	}
}
