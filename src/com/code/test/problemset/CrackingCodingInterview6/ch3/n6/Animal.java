package com.code.test.problemset.CrackingCodingInterview6.ch3.n6;

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String n) {
        name = n;
    }

    public abstract String name();

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}