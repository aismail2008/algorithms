package com.code.test.problemset.CrackingCodingCh7.Jukebox;

/**
 * Created by aliismail on 30/11/2017.
 */
public class User {
    private String name;
    private long ID;

    public User(String name, long iD) {
        this.name = name;
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public User getUser() {
        return this;
    }
}
