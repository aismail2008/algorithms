package com.code.test.designpatterns.adapter;

/**
 * Created by aliismail on 16/12/2017.
 */
public class Apple {
    public void getAColor(String str) {
        System.out.println("Apple color is: " + str);
    }
}

class Orange {
    public void getOColor(String str) {
        System.out.println("Orange color is: " + str);
    }
}

class AppleAdapter extends Apple {
    private Orange orange;

    public AppleAdapter(Orange orange) {
        this.orange = orange;
    }

    public void getAColor(String str) {
        orange.getOColor(str);
    }
}

class TestAdapter {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        apple1.getAColor("green");

        Orange orange = new Orange();

        AppleAdapter aa = new AppleAdapter(orange);
        aa.getAColor("red");
    }
}