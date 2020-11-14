package com.dreadblade.datastructures.list;

import com.dreadblade.utils.IndexOutOfBoundsException;
import com.dreadblade.utils.NoSuchElementException;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * @param <T> type of content
 *
 * In computer science, a doubly linked list is a linked data
 * structure that consists of a set of sequentially linked records
 * called nodes. Each node contains three fields: two link fields
 * (references to the previous and to the next node in the sequence
 * of nodes) and one data field. The beginning and ending nodes'
 * previous and next links, respectively, point to some kind of
 * terminator, typically a sentinel node or null, to facilitate
 * traversal of the list.
 *
 * Time complexity:
 * ┌────────────┬───────────┬──────────┬──────────┬──────────┐
 * │            │ Insertion │ Deletion │  Access  │  Search  │
 * ├────────────┼───────────┼──────────┼──────────┼──────────┤
 * │ Best case: │    O(1)   │   O(1)   │   O(1)   │   O(1)   │
 * ├────────────┼───────────┼──────────┼──────────┼──────────┤
 * │  Average:  │    O(1)   │   O(n)   │   O(1)   │   O(n)   │
 * ├────────────┼───────────┼──────────┤──────────┼──────────┤
 * │ Worst case:│    O(n)   │   O(1)   │   O(1)   │   O(n)   │
 * └────────────┴───────────┴──────────┴──────────┴──────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Doubly_linked_list
 */
public class DoublyLinkedList<T> implements List<T> {

    /**
     * Class representing linked record of list
     * @param <T> type of content in record
     */
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * @return <code>int size</code> of the list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Clears the list
     */
    @Override
    public void clear() {
        if (size != 0) {
            head = null;
            tail = null;
            size = 0;
        }
    }

    /**
     * @return <code>true</code> if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a <code>T item</code> to the list
     * @param item a <code>T item</code> to be added to the list
     * @return true if the <code>T item</code> was added
     */
    @Override
    public boolean add(T item) {
        if (tail != null) {
            tail.next = new Node<>(item, tail, null);
            tail = tail.next;
        } else if (head == null) {
            head = new Node<>(item, null, null);
        } else if (tail == null) {
            tail = new Node<>(item, head, null);
            head.next = tail;
        }
        size++;
        return true;
    }

    /**
     * Adds a <code>T item</code> to the list on the <code>int index</code> position
     * @param item a <code>T item</code> to be added to the list
     * @param index an <code>int index</code> of added <code>T item</code>
     * @return true if the <code>T item</code> was added
     */
    @Override
    public boolean add(T item, int index) {
        if (!isIndexCorrect(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            return add(item);
        }

        if (index + 1 >= size) {
            return add(item);
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = head.next;
        }

        Node<T> newNode = new Node<>(item, currentNode, currentNode.next);
        currentNode.next.prev = newNode;
        currentNode.next = newNode;

        return true;
    }

    /**
     * Removes <code>T item</code> from the list
     * @param item a <code>T item</code> to be removed from the list
     * @return true if the <code>T item</code> was removed
     */
    @Override
    public boolean remove(T item) {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(item)) {
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                } else {
                    tail = currentNode.prev;
                }
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }

                size--;
                return true;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Removes an item at <code>int index</code> position from the list
     * @param index an item with position <code>int index</code> to be removed from the list
     * @return <code>T item</code> at position <code>int index</code> if the item with this position was removed
     */
    @Override
    public T remove(int index) {
        if (!isIndexCorrect(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            throw new EmptyListException();
        }

        int count = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (count == index) {
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                } else {
                    tail = currentNode.prev;
                }
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }

                T data = currentNode.data;
                size--;
                return data;
            }
            count++;
        }

        throw new NoSuchElementException();
    }

    /**
     * @param index an <code>int index</code> position of a <code>T item</code>
     * @return <code>T item</code> at the <code>int index</code> position from the list
     */
    @Override
    public T get(int index) {
        if (!isIndexCorrect(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            throw new EmptyListException();
        }

        int count = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (count == index) {
                return currentNode.data;
            }
            count++;
            currentNode = currentNode.next;
        }
        throw new NoSuchElementException();
    }

    /**
     * @param item at an <code>int index</code> position
     * @return an <code>int index</code> position of the <code>T item</code>
     */
    @Override
    public int indexOf(T item) {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        int index = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(item)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        throw new NoSuchElementException();
    }

    /**
     * @param index an <code>int index</code> position of a <code>T item</code>
     * @return <code>true</code> if <code>int index</code> is correct
     */
    public boolean isIndexCorrect(int index) {
        return index >= 0;
    }
}
