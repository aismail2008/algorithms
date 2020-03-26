package com.code.test.designpatterns.iterator;

/**
 * Created by aliismail on 16/12/2017.
 */
public class RecordCollection implements IContainer{
    private String recordArray[] = {"first","second","third","fourth","fifth"};

    public IIterator createIterator(){
        RecordIterator iterator = new RecordIterator(recordArray);
        return iterator;
    }

}

