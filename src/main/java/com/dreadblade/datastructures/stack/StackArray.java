package com.dreadblade.datastructures.stack;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Stack implementation based on array
 *
 * In computer science, a stack is an abstract data type that serves as a collection
 * of elements, with two principal operations:
 *  • push, which adds an element to the collection, and
 *  • pop, which removes the most recently added element that was not yet removed.
 *
 * The order in which elements come off a stack gives rise to its alternative name,
 * LIFO (last in, first out). Additionally, a peek operation may give access to the
 * top without modifying the stack.
 *
 * Time complexity:
 * ┌───────────┬──────────┐
 * │ Insertion │ Deletion │
 * │───────────┼──────────│
 * │    O(1)   │   O(1)   │
 * │───────────┼──────────│
 * │    O(1)   │   O(1)   │
 * └───────────┴──────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */


import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray<T> implements Stack {

    private int capacity;
    private int size;
    private Object[] data;
    private static final int CAPACITY_VALUE = 16;

    public StackArray()
    {
        this.capacity = CAPACITY_VALUE;
        this.size = -1;
        this.data = new Object[capacity];
    }

    public StackArray(int capacity)
    {
        this.capacity = capacity;
        this.size = -1;
        this.data = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return (size == -1);
    }

    @Override
    public void push(Object item) {
        if (size + 1 == capacity)
            changeCapacity(capacity + CAPACITY_VALUE);

        size++;
        data[size] = item;
    }

    @Override
    public Object pop() {
        if (isEmpty())
            throw new EmptyStackException();

        if (size < capacity / 4)
            changeCapacity(capacity / 2);
        size--;
        return data[size + 1];
    }

    @Override
    public Object peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return data[size];
    }

    @Override
    public int getSize() {
        return size + 1;
    }

    @Override
    public void clear() {
        size = -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public void changeCapacity(int capacity) {
        data = Arrays.copyOf(data, capacity);
        this.capacity = capacity;
    }

}