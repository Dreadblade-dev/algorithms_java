package com.dreadblade.math;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Factorial number recursive algorithm
 *
 * In mathematics, the factorial of a positive integer n, denoted by n!,
 * is the product of all positive integers less than or equal to n:
 *
 * n! = n × (n − 1) × (n − 2) × (n − 3) × ⋯ × 3 × 2 × 1
 *
 * Source: https://en.wikipedia.org/wiki/Factorial
 */

public class Factorial {
    public static long factorial(int number) {

        if (number == 0L || number == 1L)
            return 1L;

        number *= factorial(number - 1);

        return (number);
    }
}
