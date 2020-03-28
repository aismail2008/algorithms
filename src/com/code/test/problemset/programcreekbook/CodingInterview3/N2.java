package com.code.test.problemset.programcreekbook.CodingInterview3;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by aliismail on 08/11/2017.
 */
public class N2 {
    //    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//    Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:
//            ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//            ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static double evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        Arrays.stream(tokens).forEach(s ->{
            if(s.equals("+")){
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                stack.push((b + a) + "");
            }else if (s.equals("-")){
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                stack.push((b - a) + "");
            }else if (s.equals("/")){
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                stack.push((b / a) + "");
            }else if (s.equals("*")){
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                stack.push((b * a) + "");
            }else{
                stack.push(s);
            }
        });
        return Double.valueOf(stack.pop());
    }
}
