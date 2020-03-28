package com.code.test.problemset.companies.Zalando;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class InquiringManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());

		List<Order> orderList = new ArrayList<Order>();
		TreeMap<Long, Long> orderPriceMap = new TreeMap<Long, Long>();
		while (n > 0) {
			String[] input = sc.nextLine().split(" ");
			if (input[0].equals("2")) {// inquire
				long eventTime = Long.valueOf(input[1]);
				while (!orderList.isEmpty()) {
					if (eventTime - orderList.get(0).time >= 60) {
						Order r = orderList.remove(0);

						Long count = orderPriceMap.remove(r.price);
						count = count - 1;
						if (count > 0) {
							orderPriceMap.put(r.price, count);
						}

					} else {
						break;
					}
				}

				if (orderPriceMap.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(orderPriceMap.lastEntry().getKey());
				}

			} else {
				long orderTime = Long.valueOf(input[2]);
				long orderPrice = Long.valueOf(input[1]);
				boolean ignore = false;
				if (!orderList.isEmpty() && orderList.get(orderList.size() - 1).time == orderTime) {
					if (orderList.get(orderList.size() - 1).price < orderPrice) {
						long oldLowPrice = orderList.remove(orderList.size() - 1).price;
						Long count = orderPriceMap.remove(oldLowPrice);
						count = count - 1;
						if (count > 0) {
							orderPriceMap.put(oldLowPrice, count);
						}
					} else {
						ignore = true;
					}
				} else {
					while (orderList.size() > 0) {
						if (orderTime - orderList.get(0).time >= 60) {
							Order r = orderList.remove(0);
							Long count = orderPriceMap.remove(r.price);
							count = count - 1;
							if (count > 0) {
								orderPriceMap.put(r.price, count);
							}
						} else {
							break;
						}
					}
				}
				if (!ignore) {
					Order or = new Order(orderPrice, orderTime);
					orderList.add(or);
					Long count = orderPriceMap.get(orderPrice);
					count = count == null ? 1 : count + 1;
					orderPriceMap.put(orderPrice, count);
				}
			}
			n--;
		}
		sc.close();
	}

	public static class Order {
		public long price;
		public long time;

		public Order(long price, long time) {
			this.price = price;
			this.time = time;
		}
	}
}
