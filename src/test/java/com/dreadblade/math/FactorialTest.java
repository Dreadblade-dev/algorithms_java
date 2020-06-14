package com.dreadblade.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void factorialOfZeroTest() {
        long expected = 1L;
        long actual = Factorial.factorial(0);
        assertEquals(expected, actual);
    }

    @Test
    public void factorialOfNthTest() {
        long expected = 1L;
        long actual = Factorial.factorial(1);
        assertEquals(expected, actual);

        expected = 6L;
        actual = Factorial.factorial(3);
        assertEquals(expected, actual);

        expected = 120L;
        actual = Factorial.factorial(5);
        assertEquals(expected, actual);

        expected = 40320L;
        actual = Factorial.factorial(8);
        assertEquals(expected, actual);

        expected = 3_628_800L;
        actual = Factorial.factorial(10);
        assertEquals(expected, actual);

        expected = 479_001_600L;
        actual = Factorial.factorial(12);
        assertEquals(expected, actual);
    }
}