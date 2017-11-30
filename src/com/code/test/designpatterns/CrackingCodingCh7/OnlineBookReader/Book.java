package com.code.test.designpatterns.CrackingCodingCh7.OnlineBookReader;

/**
 * Created by aliismail on 30/11/2017.
 */
public class Book {
    private int bookId;
    private String details;

    public Book(int id, String det) {
        bookId = id;
        details = det;
    }

    public void update() {
    }

    public int getID() {
        return bookId;
    }

    public void setID(int id) {
        bookId = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
