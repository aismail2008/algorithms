package com.code.test.designpatterns.Builder;

/* A customer ordering a pizza. */
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiianPizzabuilder);
        Pizza pizza = waiter.getPizza();

        waiter.setPizzaBuilder(spicyPizzaBuilder);

        pizza = waiter.getPizza();
    }
}