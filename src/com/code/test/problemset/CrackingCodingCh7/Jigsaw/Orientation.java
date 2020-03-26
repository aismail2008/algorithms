package com.code.test.problemset.CrackingCodingCh7.Jigsaw;

/**
 * Created by aliismail on 30/11/2017.
 */
public enum Orientation {
    LEFT, TOP, RIGHT, BOTTOM; // Should stay in this order

    public Orientation getOpposite() {
        switch (this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case TOP:
                return BOTTOM;
            case BOTTOM:
                return TOP;
            default:
                return null;
        }
    }
}