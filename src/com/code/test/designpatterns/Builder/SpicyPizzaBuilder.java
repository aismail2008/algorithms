package com.code.test.designpatterns.Builder;

/* "ConcreteBuilder" */
class SpicyPizzaBuilder implements PizzaBuilder {
    private String dough = "SpicyPizzaDough";
    private String sauce = "SpicyPizzaSauce";
    private String topping = "SpicyPizzaTopping";

    public PizzaBuilder buildDough() {
        dough = "Extra_SpicyPizzaDough";
        return this;
    }

    public PizzaBuilder buildSauce() {
        sauce = "Extra_SpicyPizzaSauce";
        return this;
    }

    public PizzaBuilder buildTopping() {
        topping = "Extra_SpicyPizzaTopping";
        return this;
    }

    public Pizza build() {
        return new Pizza(this.dough, this.sauce, this.topping);
    }
}
