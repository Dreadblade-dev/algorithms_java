package com.dreadblade.search;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 *
 * In computer science, a linear search or sequential search is a method for
 * finding an element within a list. It sequentially checks each element
 * of the list until a match is found or the whole list has been searched
 *
 * Time complexity:
 * ┌────────────────┬────────────────┬───────────────┐
 * │   Worst-case   │  Average-case  │   Best-case   │
 * ├────────────────┼────────────────┼───────────────┤
 * │      O(n)      │      O(n)      │     O(1)      │
 * └────────────────┴────────────────┴───────────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Linear_search
 */
public class LinearSearch {

    /**
     * Linear search algorithm
     * @param array <code>int[]</code> array
     * @param key an <code>int</code> value that need to be find
     * @return <code>-1</code> if key is not found otherwise the key <code>int</code> index in the array
     */
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }

        return -1;
    }
}
