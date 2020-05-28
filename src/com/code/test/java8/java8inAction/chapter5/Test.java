package com.code.test.java8.java8inAction.chapter5;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    interface ExchangeService {
        Optional<BigDecimal> rate(String currency);
    }

    static class SoldProduct {
        String name;
        BigDecimal price;
        String currency;

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
        List<SimpleSoldProduct> products;
        BigDecimal total;

        public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
            this.products = products;
            this.total = total;
        }
    }

    static class SimpleSoldProduct {
        String name;
        BigDecimal price;

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

		return new SoldProductsAggregate(sspList, sspList.stream().map(a -> a.getPrice()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        System.out.println("=========1- Find all transactions in the year 2011 and sort them by value (small to high).===========");
        // 1- Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue)).forEach(System.out::println);

        System.out.println("=========2. What are all the unique cities where the traders work?===========");
        // 2. What are all the unique cities where the traders work?
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);

        System.out.println("=========3. Find all traders from Cambridge and sort them by name.===========");
        // 3. Find all traders from Cambridge and sort them by name.
        Predicate<Trader> cambOnly = t -> t.getCity().equalsIgnoreCase("Cambridge");
        transactions.stream().map(Transaction::getTrader).filter(cambOnly).distinct().sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);

        System.out.println("=========4. Return a string of all traders names sorted alphabetically.===========");
        // 4. Return a string of all traders names sorted alphabetically.
        transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().forEach(System.out::println);

        System.out.println("=========5. Are any traders based in Milan?===========");
        // 5. Are any traders based in Milan?
        System.out.println(transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equalsIgnoreCase("Milan")));

        System.out.println("=========6. Print all transactions values from the traders living in Cambridge===========");
        // 6. Print all transactions values from the traders living in Cambridge
        transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

        System.out.println("=========7. What is the highest value of all the transactions?===========");
        // 7. What is the highest value of all the transactions?
        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
        transactions.stream().mapToInt(Transaction::getValue).max().ifPresent(System.out::println);

        System.out.println("=========8. Find the transaction with the smallest value===========");
        // 8. Find the transaction with the smallest value
        BinaryOperator<Transaction> accumlator = (a, b) -> a.getValue() > b.getValue() ? b : a;
        transactions.stream().reduce(accumlator).ifPresent(System.out::println);

    }
}
