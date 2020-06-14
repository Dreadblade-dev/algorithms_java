package com.dreadblade.math;

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
