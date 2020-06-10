package com.dreadblade.search;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 *
 * In computer science, binary search, also known as half-interval search,
 * logarithmic search, or binary chop, is a search algorithm that finds
 * the position of a target value within a sorted array.
 *
 * Time complexity:
 * ┌────────────────┬────────────────┬───────────────┐
 * │   Worst-case   │  Average-case  │   Best-case   │
 * ├────────────────┼────────────────┼───────────────┤
 * │    O(log n)    │    O(log n)    │     O(1)      │
 * └────────────────┴────────────────┴───────────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Binary_search_algorithm
 */

public class BinarySearch {
    public static int binarySearch(int[] sortedArray, int key, int left, int right)
    {
        int middle = (left + right) / 2;

        if (sortedArray[middle] == key)
            return middle;
        if (sortedArray[middle] > key)
            return binarySearch(sortedArray, key, left, middle);
        if (sortedArray[middle] < key)
            return binarySearch(sortedArray, key, middle, right);

        return -1;
    }
}
