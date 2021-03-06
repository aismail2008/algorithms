package com.code.test.problemset.CrackingCodingInterview6.ch9.Q2_SocialNetworks;

import java.util.ArrayList;

public class Person {
    private ArrayList<Integer> friends = new ArrayList<>();
    private int personID;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getID() {
        return personID;
    }

    public void addFriend(int id) {
        friends.add(id);
    }

    public Person(int id) {
        this.personID = id;
    }
}
