package com.code.test;

import com.code.test.tdd.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**

 */
public class Problem {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));
        solve("");
    }

    public static void solve(String digits){
    }
}