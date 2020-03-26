package com.code.test.designpatterns.singleton;

public class AmericaPresident {
	private static AmericaPresident thePresident;

	private AmericaPresident() {
	}

	public static AmericaPresident getInstance() {
		if (thePresident == null) {
			synchronized (AmericaPresident.class) {
				if (thePresident == null) {
					thePresident = new AmericaPresident();
				}
			}
		}
		return thePresident;
	}
}