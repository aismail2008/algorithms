package com.code.test.designpatterns.CrackingCodingCh7.CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Director;
    }
}
