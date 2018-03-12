package com.code.test.designpatterns.iterator;

/**
 * Created by aliismail on 16/12/2017.
 */
public class RecordCollection implements IContainer{
    private String recordArray[] = {"first","second","third","fourth","fifth"};

    public IIterator createIterator(){
        RecordIterator iterator = new RecordIterator();
        return iterator;
    }

    private class RecordIterator implements IIterator<String>{
        private int index;

        public boolean hasNext(){
            if (index < recordArray.length)
                return true;
            else
                return false;
        }

        public String next(){
            if (this.hasNext())
                return recordArray[index++];
            else
                return null;
        }
    }
}