package com.code.test.problemset.CrackingCodingInterview6.Ch7.CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Responder;
    }
}