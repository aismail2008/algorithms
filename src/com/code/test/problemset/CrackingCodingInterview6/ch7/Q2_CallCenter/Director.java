package com.code.test.problemset.CrackingCodingInterview6.ch7.Q2_CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Director;
    }
}
