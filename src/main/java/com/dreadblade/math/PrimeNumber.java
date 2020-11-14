package com.dreadblade.math;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 *
 * Time complexity: O(sqrt(n))
 *
 * A prime number (or a prime) is a natural number greater than 1
 * that is not a product of two smaller natural numbers. A natural
 * number greater than 1 that is not prime is called a composite number.
 *
 * Source: https://en.wikipedia.org/wiki/Prime_number
 */
public class PrimeNumber {
    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        long lim = (long) Math.sqrt(n);

        for (int i = 5; i <= lim; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
