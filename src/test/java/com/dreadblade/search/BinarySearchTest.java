package com.dreadblade.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    static int[] array = new int[33];

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < array.length; i++)
            array[i] = i * i;
    }

    @Test
    public void testCoverage1() {
        int actual = BinarySearch.binarySearch(array, 0, 0, array.length-1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testCoverage2() {
        int actual = BinarySearch.binarySearch(array, 64, 0, array.length-1);
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void testCoverage3() {
        int actual = BinarySearch.binarySearch(array, 256, 0, array.length-1);
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void testCoverage4() {
        int actual = BinarySearch.binarySearch(array, 576, 0, array.length);
        int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void testCoverage5() {
        int actual = BinarySearch.binarySearch(array, 1024, 0, array.length);
        int expected = 32;
        assertEquals(expected, actual);
    }
}