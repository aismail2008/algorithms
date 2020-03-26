package com.code.test.designpatterns.observer;

/**
 * Created by aliismail on 16/12/2017.
 */
public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject s) {
        // Here you do you business
        System.out.println(this.name + " got notified!");
        //print job list
        System.out.println(s);
    }
}