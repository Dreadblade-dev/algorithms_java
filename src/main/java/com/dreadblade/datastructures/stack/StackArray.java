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
 * └───────────┴──────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */


import java.util.Arrays;

public class StackArray<T> implements Stack<T> {

    private int capacity;
    private int size;
    private Object[] data;
    private static final int CAPACITY_VALUE = 16;

    /**
     * StackArray constructor
     */
    public StackArray()
    {
        this.capacity = CAPACITY_VALUE;
        this.size = -1;
        this.data = new Object[capacity];
    }

    /**
     * StackArray constructor with capacity parameter
     * @param capacity StackArray initial <code>int</code> capacity
     */
    public StackArray(int capacity)
    {
        this.capacity = capacity;
        this.size = -1;
        this.data = new Object[capacity];
    }

    /**
     * @return true if StackArray is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == -1);
    }

    /**
     * Pushes item on top of the StackArray
     * @param item <code>T item</code> to be pushed
     */
    @Override
    public void push(T item) {
        if (size + 1 == capacity)
            changeCapacity(capacity + CAPACITY_VALUE);

        size++;
        data[size] = item;
    }

    /**
     * Returns and delete item on top of the StackArray
     * @return <code>T item</code> on top of the StackArray
     */
    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        if (size < capacity / 4)
            changeCapacity(capacity / 2);
        size--;
        return (T) data[size + 1];
    }

    /**
     * Returns item on top of the StackArray
     * @return <code>T item</code> on top of the StackArray
     */
    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return (T) data[size];
    }

    /**
     * @return StackArray <code>int size</code>
     */
    @Override
    public int getSize() {
        return size + 1;
    }

    /**
     * Clears the StackArray
     */
    @Override
    public void clear() {
        size = -1;
    }

    /**
     * @return StackArray <code>int capacity</code>
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Changes StackArray capacity to a new value
     * @param capacity new StackArray <code>int capacity</code>
     */
    public void changeCapacity(int capacity) {
        data = Arrays.copyOf(data, capacity);
        this.capacity = capacity;
    }

}