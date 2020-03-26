package com.code.test.java8;

public class FunctionalInterface {

    public static void main(String[] args) {
        testLambda();
    }

    public static void testLambda() {
        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;
        // with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));

        // with parenthesis
        GreetingService greetService = message -> System.out.println("Hello " + message);
        greetService.sayMessage("Suresh");
    }

    // ----------------------Functional Interface --------------------------//
    // must be on method non implemented
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    static private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
