package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        if (op == null) {
            return 0;
        }

    switch (op) {
        case "add", "add-again":
            return a + b;

        case "sub", "sub-again":
            return a - b;

        case "mul":
            return a * b;

        case "div":
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero");
            }
            return a / b;

        case "mod":
            if (b == 0) {
                throw new IllegalArgumentException("Modulo by zero");
            }
            return a % b;

        case "pow":
            return (int) Math.pow(a, b);

        default:
            return 0;
    }
    }

    public int sumValues(int a, int b) {
        return a + b;
    }
}
