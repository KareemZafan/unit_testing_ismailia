package org.iti.mobile;

public class Calculator {

    public double sum(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if(b == 0 ){
            throw new ArithmeticException("Dividing By Zero");
        }
        return a / b;
    }

    public double squareRoot(double a) {
        return Math.sqrt(a);
    }
}
