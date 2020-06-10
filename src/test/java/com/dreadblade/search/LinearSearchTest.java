package com.dreadblade.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearSearchTest {

    static int[] array = new int[33];

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < array.length; i++)
            array[i] = i * i;
    }

    @Test
    public void testCoverage1() {
        int actual = LinearSearch.linearSearch(array, 0);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testCoverage2() {
        int actual = LinearSearch.linearSearch(array, 256);
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void testCoverage3() {
        int actual = LinearSearch.linearSearch(array, 1024);
        int expected = 32;
        assertEquals(expected, actual);
    }
}