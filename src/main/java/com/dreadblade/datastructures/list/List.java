package com.dreadblade.datastructures.list;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Represents interface for List collections
 * @param <T> type of content
 */
public interface List<T> {
    int getSize();
    void clear();
    boolean isEmpty();
    boolean add(T item);
    boolean add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    T get(int index);
    int indexOf(T item);
}
