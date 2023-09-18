package com.code.test.designpatterns.Builder;

/* "ConcreteBuilder" */

/**
 * The key feature of Builder pattern is that it involves a step-by-step process to build something, i.e.,
 * every produce will follow the same process even though each step is different.
 *
 * In the following example, we can define a drink builder called StarbucksBuilder which will build a Starbucks drink.
 * StarbucksBuilder has several steps to build a Starbucks drink, such as buildSize() and buildDrink().
 * And finally return the drink built.
 */
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
