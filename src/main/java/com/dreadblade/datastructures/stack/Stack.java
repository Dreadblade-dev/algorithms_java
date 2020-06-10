package com.dreadblade.datastructures.stack;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 */

public interface Stack<T> {
    boolean isEmpty();
    int getSize();
    void clear();
    void push(T item);
    T pop();
    T peek();
}
