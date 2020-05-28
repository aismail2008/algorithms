package com.code.test.problemset.companies.adyen;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProblem {
    interface ExchangeService {
        Optional<BigDecimal> rate(String currency);
    }

    static class SoldProduct {
        private final String name;
        private final BigDecimal price;
        private final String currency;

        public SoldProduct(String name, BigDecimal price, String currency) {
            this.name = name;
            this.price = price;
            this.currency = currency;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public String getCurrency() {
            return currency;
        }

    }

    static class SoldProductsAggregate {
        private final List<SimpleSoldProduct> products;
        private final BigDecimal total;

        public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
            this.products = products;
            this.total = total;
        }
    }

    static class SimpleSoldProduct {
        private final String name;
        private final BigDecimal price;

        public SimpleSoldProduct(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    ExchangeService exchangeService;

    SoldProductsAggregate aggregate_(Stream<SoldProduct> products) {
        if (products == null)
            products = Stream.empty();

        return products
                .map(sp -> Optional
                        .ofNullable(exchangeService.rate(sp.getCurrency()))
                        .flatMap(rate -> rate)
                        .filter(rate -> rate.compareTo(BigDecimal.ZERO) >= 0)
                        .map(rate -> new SimpleSoldProduct(sp.getName(), rate.multiply(sp.getPrice())))
                        .map(p -> new SoldProductsAggregate(Collections.singletonList(p), p.getPrice()))
                        .orElse(null))
                .filter(Objects::nonNull)
                .reduce((a, b) -> {
                    List<SimpleSoldProduct> l = new ArrayList<>(a.products);
                    l.addAll(b.products);
                    return new SoldProductsAggregate(l, a.total.add(b.total));
                }).orElse(new SoldProductsAggregate(new ArrayList<>(), BigDecimal.ZERO));
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
		if (products == null)
			products = Stream.empty();

		List<SimpleSoldProduct> sspList = products
				.map(sp -> Optional
						.ofNullable(exchangeService.rate(sp.getCurrency()))
						.flatMap(rate -> rate)
						.filter(rate -> rate.compareTo(BigDecimal.ZERO) >= 0)
						.map(rate -> new SimpleSoldProduct(sp.getName(), rate.multiply(sp.getPrice())))
						.orElse(null))
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		return new SoldProductsAggregate(sspList, sspList.stream().map(SimpleSoldProduct::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }
}
