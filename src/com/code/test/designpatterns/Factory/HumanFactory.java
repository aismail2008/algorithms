package com.code.test.designpatterns.Factory;


//java.util.Calendar - getInstance()
//java.util.Calendar - getInstance(TimeZone zone)
//java.util.Calendar - getInstance(Locale aLocale)
//java.util.Calendar - getInstance(TimeZone zone, Locale aLocale)
//java.text.NumberFormat - getInstance()
//java.text.NumberFormat - getInstance(Locale inLocale)
public class HumanFactory {
	public static Human createHuman(String m) {
		Human p = null;
		if (m.equals("boy")) {
			p = new Boy();
		} else if (m.equals("girl")) {
			p = new Girl();
		}

		return p;
	}
}