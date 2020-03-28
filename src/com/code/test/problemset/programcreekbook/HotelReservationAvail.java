package com.code.test.problemset.programcreekbook;

import java.util.*;

public class HotelReservationAvail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> s1 = new ArrayList<String>();
		s1.add("Westin, 10");
		s1.add("Best Western, 20");
		s1.add("Hilton, 10");

		List<String> s2 = new ArrayList<String>();
		s2.add("Hilton, 2015-04-02, 2015-04-03");
		s2.add("Hilton, 2015-04-02, 2015-04-04");
		s2.add("Hilton, 2015-04-02, 2015-04-12");
		s2.add("Westin, 2015-05-01, 2015-05-20");

		solution(s1, s2);
	}

	private static void solution(List<String> hotels, List<String> reservations) {
		Map<String, Integer> hotelsAvailablity = new HashMap<String, Integer>();
		for (String s : hotels) {
			hotelsAvailablity.put(s.substring(0, s.indexOf(",")), Integer.valueOf(s.substring(s.indexOf(",") + 2, s.length())));
		}
		Map<String, String> hotelsRushHour = new HashMap<String, String>();

		for (String s : reservations) {
			String period = hotelsRushHour.get(s.substring(0, s.indexOf(",")));
			if (period == null) {
				System.out.println(s);
				hotelsRushHour.put(s.substring(0, s.indexOf(",")), s.substring(s.indexOf(",") + 2, s.length()));
			} else {
				Calendar date = Calendar.getInstance();
				date.set(Calendar.YEAR, Integer.parseInt(period.substring(0, 4)) - 1900);
				date.set(Calendar.MONTH, Integer.parseInt(period.substring(5, 7)) - 1);
				date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(period.substring(8, 10)));
				Date firstDateInter = date.getTime();

				Date secondDateInter = new Date(Integer.parseInt(period.substring(12, 16)) - 1900, Integer.parseInt(period.substring(17, 19)) - 1, Integer.parseInt(period.substring(20, 22)));
				String dateS = s.substring(s.indexOf(" ") + 1);
				Date thirdDateInter = new Date(Integer.parseInt(dateS.substring(0, 4)) - 1900, Integer.parseInt(dateS.substring(5, 7)) - 1, Integer.parseInt(dateS.substring(8, 10)));
				Date fourthDateInter = new Date(Integer.parseInt(dateS.substring(12, 16)) - 1900, Integer.parseInt(dateS.substring(17, 19)) - 1, Integer.parseInt(dateS.substring(20, 22)));

				int maxAvi = hotelsAvailablity.get(s.substring(0, s.indexOf(",")));
				if (intersection(firstDateInter, secondDateInter, thirdDateInter, fourthDateInter) < maxAvi) {
					System.out.println(s);
				}
			}
		}

	}

	private static int intersection(Date firstDateInter, Date secondDateInter, Date thirdDateInter, Date fourthDateInter) {
		if (thirdDateInter.compareTo(firstDateInter) >= 0 && thirdDateInter.compareTo(secondDateInter) <= 0) {
			if (fourthDateInter.compareTo(secondDateInter) > 0) {
				return (int) (secondDateInter.getTime() - thirdDateInter.getTime()) / 86400000;
			} else {
				return (int) (fourthDateInter.getTime() - thirdDateInter.getTime()) / 86400000;
			}
		} else if (fourthDateInter.compareTo(firstDateInter) >= 0 && fourthDateInter.compareTo(secondDateInter) <= 0) {
			if (thirdDateInter.compareTo(firstDateInter) < 0) {
				return (int) (fourthDateInter.getTime() - firstDateInter.getTime()) / 86400000;
			} else {
				return (int) (fourthDateInter.getTime() - thirdDateInter.getTime()) / 86400000;
			}
		}
		return 0;
	}

}
