package com.code.test.problemset.CrackingCodingInterview6.ch7.CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
public enum Rank {
    Responder (0),
    Manager (1),
    Director (2);

    private int value;

    private Rank(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
