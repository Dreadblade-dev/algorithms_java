package com.dreadblade.datastructures.tree;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Represents interface for Tree collections
 * @param <T> type of content
 */
public interface Tree<T> {
    void add(T item);
    boolean remove(T item);
    boolean contains(T item);
    int height();
    void clear();
    boolean isEmpty();
    int size();
}
