package com.code.test.problemset.CrackingCodingCh7.CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
class Manager extends Employee {
    public Manager(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Manager;
    }
}