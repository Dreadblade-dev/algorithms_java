package com.dreadblade.math;

import org.junit.Test;

import static com.dreadblade.math.PrimeNumber.isPrime;
import static org.junit.Assert.*;

public class PrimeNumberTest {

    @Test
    public void PrimeNumberCheckIsCorrect() {
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertTrue(isPrime(5));
        assertTrue(isPrime(7));
        assertTrue(isPrime(11));
        assertFalse(isPrime(4));
        assertFalse(isPrime(6));
        assertFalse(isPrime(8));
        assertFalse(isPrime(9));
        assertFalse(isPrime(10));
        assertFalse(isPrime(12));
    }
}