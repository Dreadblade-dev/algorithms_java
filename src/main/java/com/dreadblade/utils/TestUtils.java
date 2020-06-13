package com.dreadblade.utils;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Testing utils for algorithms
 */

public class TestUtils {
    /**
     * Generates an <code>Integer</code> array with <code>int</code> size where every value
     * is random <code>int</code> value in range between min and max
     * @param size The <code>int</code> size of array
     * @param min The minimum <code>int</code> value in the range
     * @param max The maximum <code>int</code> value in the range
     * @return An <code>Integer</code> array with <code>int</code> size full of random <code>int</code> values in range between min and max
     */
    public static Integer[] randomIntegerArray(int size, int min, int max) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++)
            array[i] = randomValue(min, max);
        return array;
    }

    /**
     * Generates a random <code>int</code> value between [min, max)
     * @param min The minimum <code>int</code> value in the range
     * @param max The maximum <code>int</code> value in the range
     * @return random <code>int</code> value between [min, max)
     */
    public static int randomValue(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
