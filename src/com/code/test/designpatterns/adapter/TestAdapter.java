package com.code.test.designpatterns.adapter;

class TestAdapter {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new AppleAdapter(new Orange());

        apple1.getAColor("green");
        apple2.getAColor("red");
    }
}
