package com.code.test.problemset.CrackingCodingInterview6.ch15.Q03_DiningPhilosophers;

public class Question {
	public static int size = 3;
	
	public static int leftOf(int i) {
		return i;
	}
	
	public static int rightOf(int i) {
		return (i + 1) % size;
	}
	
	public static void main(String[] args) {		
		Philosopher.Chopstick[] chopsticks = new Philosopher.Chopstick[size + 1];
		for (int i = 0; i < size + 1; i++) {
			chopsticks[i] = new Philosopher.Chopstick();
		}
		
		Philosopher[] philosophers = new Philosopher[size];
		for (int i = 0; i < size; i++) {
			Philosopher.Chopstick left = chopsticks[leftOf(i)];
			Philosopher.Chopstick right = chopsticks[rightOf(i)];
			philosophers[i] = new Philosopher(i, left, right);
		}
		
		for (int i = 0; i < size; i++) {
			philosophers[i].start();
		}		
	}

}
