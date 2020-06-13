package com.dreadblade.sort;

import org.junit.Test;

import static org.junit.Assert.*;

import com.dreadblade.utils.TestUtils;

public class BubbleSortTest {

    @Test
    public void bubbleSortTestPositiveOnly() {
        Integer[] array = TestUtils.randomIntegerArray(64, 0, 101);

        BubbleSort.bubbleSort(array);

        for (int i = 0; i < array.length - 1; i++)
            assertTrue(array[i] <= array[i + 1]);
    }

    @Test
    public void bubbleSortTestNegativeOnly() {
        Integer[] array = TestUtils.randomIntegerArray(64, -100, 1);

        BubbleSort.bubbleSort(array);

        for (int i = 0; i < array.length - 1; i++)
            assertTrue(array[i] <= array[i + 1]);
    }

    @Test
    public void bubbleSortTestPositiveAndNegative() {
        Integer[] array = TestUtils.randomIntegerArray(64, -100, 101);

        BubbleSort.bubbleSort(array);

        for (int i = 0; i < array.length - 1; i++)
            assertTrue(array[i] <= array[i + 1]);
    }
}