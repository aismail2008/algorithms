package com.code.test.designpatterns.strategy;

//1). Java.util.Collections#sort(List list, Comparator < ? super T > c)
//2). java.util.Arrays#sort(T[], Comparator < ? super T > c)

public class Situation {
	private Strategy strategy;

	public Situation(Strategy strategy) {
		this.strategy = strategy;
	}

	public void handleByPolice(int speed) {
		this.strategy.processSpeeding(speed);
	}

	public static void main(String[] args) {
		HardPolice hp = new HardPolice();
		NicePolice ep = new NicePolice();

		// In situation 1, a hard officer is met
		// In situation 2, a nice officer is met
		Situation s1 = new Situation(hp);
		Situation s2 = new Situation(ep);

		// the result based on the kind of police officer.
		s1.handleByPolice(10);
		s2.handleByPolice(10);
	}

}