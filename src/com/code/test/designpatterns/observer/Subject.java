package com.code.test.designpatterns.observer;

/**
 * Created by aliismail on 16/12/2017.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObservers();
}
