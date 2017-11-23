package com.code.test;

public class ThreadExtends extends Thread {
	public ThreadExtends() {
	}

	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " is running");
	}
	
	public static void main(String[] args){
		Thread t = new ThreadExtends();
		t.start();
	}
}
