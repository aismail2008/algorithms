package com.code.test.designpatterns.iterator;

class RecordIterator implements IIterator<String>{
    private int index;
    String[] recordArray;

    public RecordIterator(String[] recordArray) {
        this.recordArray = recordArray;
    }

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
