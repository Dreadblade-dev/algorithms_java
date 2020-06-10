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
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }

        return -1;
    }
}
