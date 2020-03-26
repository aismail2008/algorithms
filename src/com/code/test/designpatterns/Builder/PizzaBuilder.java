package com.code.test.designpatterns.Builder;

/* "Abstract Builder" */
interface PizzaBuilder {
    public abstract Pizza build();

    public abstract PizzaBuilder buildDough();

    public abstract PizzaBuilder buildSauce();

    public abstract PizzaBuilder buildTopping();
}
