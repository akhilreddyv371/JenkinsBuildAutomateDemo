package com.example;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        calculator.add(1, 2);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        calculator.subtract(1, 2);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        calculator.multiply(1, 2);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        calculator.divide(1, 2);
    }

}
