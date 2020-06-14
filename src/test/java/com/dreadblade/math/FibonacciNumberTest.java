package com.dreadblade.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumberTest {
    @Test
    public void fibonacciNthTest() {
        long expected = 1L;
        long actual = FibonacciNumber.fibonacciNumber(2);
        assertEquals(expected, actual);

        expected = 2L;
        actual = FibonacciNumber.fibonacciNumber(3);
        assertEquals(expected, actual);

        expected = 5L;
        actual = FibonacciNumber.fibonacciNumber(5);
        assertEquals(expected, actual);

        expected = 21L;
        actual = FibonacciNumber.fibonacciNumber(8);
        assertEquals(expected, actual);

        expected = 55L;
        actual = FibonacciNumber.fibonacciNumber(10);
        assertEquals(expected, actual);

        expected = 	102_334_155L;
        actual = FibonacciNumber.fibonacciNumber(40);
        assertEquals(expected, actual);

        expected = 	7_778_742_049L;
        actual = FibonacciNumber.fibonacciNumber(49);
        assertEquals(expected, actual);
    }
}