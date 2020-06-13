package com.dreadblade.sort;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 *
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
 * that repeatedly steps through the list, compares adjacent elements and swaps them
 * if they are in the wrong order. The pass through the list is repeated until the
 * list is sorted. The algorithm, which is a comparison sort, is named for the way
 * smaller or larger elements "bubble" to the top of the list.
 *
 * Time complexity:
 * ┌────────────────┬────────────────┬───────────────┐
 * │   Worst-case   │  Average-case  │   Best-case   │
 * ├────────────────┼────────────────┼───────────────┤
 * │     O(n^2)     │     O(n^2)     │     O(n)      │
 * └────────────────┴────────────────┴───────────────┘
 *
 * https://en.wikipedia.org/wiki/Bubble_sort
 */
public class BubbleSort {

    /**
     * Bubble sort algorithm
     * @param array array to be sorted
     * @param <T> comparable Type
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    needIteration = true;
                }
            }
        }
    }
}
