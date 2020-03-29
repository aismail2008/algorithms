package com.code.test.problemset.CrackingCodingInterview6.ch7.Jigsaw;

/**
 * Created by aliismail on 30/11/2017.
 */
public enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        switch (this) {
            case INNER:
                return OUTER;
            case OUTER:
                return INNER;
            default:
                return null;
        }
    }
}
