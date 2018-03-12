package com.code.test.designpatterns.iterator;

/**
 * Created by aliismail on 16/12/2017.
 */

interface IIterator<T> {
    public boolean hasNext();
    public T next();
}