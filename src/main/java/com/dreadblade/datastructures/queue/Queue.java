package com.dreadblade.datastructures.queue;

public interface Queue<T> {
    boolean isEmpty();
    int getSize();
    void clear();
    void enqueue(T item);
    T dequeue() throws EmptyQueueException;
    T front() throws EmptyQueueException;
}
