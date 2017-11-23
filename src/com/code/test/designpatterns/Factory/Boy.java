package com.code.test.designpatterns.Factory;

public class Boy implements Human {
	@Override
	public void Talk() {
		System.out.println("Boy is talking...");
	}

	@Override
	public void Walk() {
		System.out.println("Boy is walking...");
	}
}
