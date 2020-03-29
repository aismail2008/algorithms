package com.code.test.problemset.CrackingCodingInterview6.ch7.CallCenter;

/**
 * Created by aliismail on 28/11/2017.
 */
public class Test {

//    Call Center: Imagine you have a call center with three levels of employees: respondent, manager,
//    and director. An incoming telephone call must be first allocated to a respondent who is free. If the
//    respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not
//    free or not able to handle it, then the call should be escalated to a director. Design the classes and
//    data structures for this problem. Implement a method dispatchCall () which assigns a call to
//    the first available employee.
    public static void main(String[] args) {
        CallHandler ch = new CallHandler();
        ch.dispatchCall(new Caller(1, "Ali"));
    }

}

