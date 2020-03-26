package com.code.test.designpatterns.adapter;

class TestAdapter {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.getAColor("green");

        Orange orange = new Orange();

        AppleAdapter aa = new AppleAdapter(orange);
        aa.getAColor("red");
    }
}
