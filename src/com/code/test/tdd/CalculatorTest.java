package com.code.test.tdd;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }
}