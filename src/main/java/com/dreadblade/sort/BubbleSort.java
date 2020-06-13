package com.dreadblade.sort;

public class BubbleSort {
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
