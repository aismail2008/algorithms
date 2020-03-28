package com.code.test.problemset.CrackingCodingInterview6.Ch7.CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Director;
    }
}
