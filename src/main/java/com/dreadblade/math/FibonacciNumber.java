package com.dreadblade.math;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Fast Fibonacci algorithm realization
 * Time complexity:
 * O(n)
 *
 * In mathematics, the Fibonacci numbers, commonly denoted F(n),
 * form a sequence, called the Fibonacci sequence, such that
 * each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1,
 * and
 * F(n) = F(n − 1) + F(n − 2),
 * for n > 1.
 * Source: https://en.wikipedia.org/wiki/Fibonacci_number
 */

public class FibonacciNumber {
    private static int[] array = new int[128];

    public static long fibonacciNumber(int n) {
        array[0] = 0;
        array[1] = 1;

        if (array[n] != 0 || n == 0)
            return array[n];

        if (array[n - 1] != 0)
            array[n] = array[n - 2] + array[n - 1];

        return fibonacciNumber(n - 2) + fibonacciNumber(n - 1);
    }
}
