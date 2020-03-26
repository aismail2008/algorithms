package com.code.test.designpatterns.Builder;

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder implements PizzaBuilder {
    private String dough = "HawaiianPizzaDough";
    private String sauce = "HawaiianPizzaSauce";
    private String topping = "HawaiianPizzaTopping";

    public PizzaBuilder buildDough() {
        dough= "Extra_HawaiianPizzaDough";
        return this;
    }

    public PizzaBuilder buildSauce() {
        sauce = "Extra_HawaiianPizzaSauce";
        return this;
    }

    public PizzaBuilder buildTopping() {
        topping = "Extra_HawaiianPizzaTopping";
        return this;
    }

    public Pizza build() {
        return new Pizza(this.dough, this.sauce, this.topping);
    }
}
