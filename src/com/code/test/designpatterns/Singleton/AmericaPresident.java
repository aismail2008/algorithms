package com.code.test.designpatterns.Singleton;

public class AmericaPresident {
	private static AmericaPresident thePresident;

	private AmericaPresident() {
	}

	public static AmericaPresident getInstance() {

		if (thePresident == null) {
			synchronized (AmericaPresident.class) {
				thePresident = new AmericaPresident();
			}
		}
		return thePresident;
	}
}