package com.code.test.designpatterns.Builder;

/* "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        Pizza pizza =  pizzaBuilder.build();
        // Or
        pizza = new Pizza.CustomPizzaBuilder()
                .buildDough("Italian")
                .buildSauce("Red Sauce")
                .buildTopping("Extra Pepproni")
                .build();
        // Or
        pizza = pizzaBuilder
                .buildDough()
                .buildSauce()
                .buildTopping()
                .build();

        return pizza;
    }
}
