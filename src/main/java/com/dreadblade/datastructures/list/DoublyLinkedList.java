package com.dreadblade.datastructures.list;

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
 * ┌───────────┬───────────┬──────────┬──────────┼──────────┐
 * │           │ Insertion │ Deletion │  Access  │  Search  │
 * ├───────────┼───────────┼──────────┼──────────┼──────────┤
 * │Best case: │    O(1)   │   O(1)   │   O(1)   │   O(1)   │
 * ├───────────┼───────────┼──────────┼──────────┼──────────┤
 * │ Average:  │    O(1)   │   O(n)   │   O(1)   │   O(n)   │
 * ├───────────┼───────────┼──────────┤──────────┼──────────┤
 * │Worst case:│    O(n)   │   O(1)   │   O(1)   │   O(n)   │
 * └───────────┴───────────┴──────────┴──────────┴──────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Doubly_linked_list
 */
public class DoublyLinkedList<T> implements List<T> {

    private class Node<T> {
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

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        if (size != 0) {
            head = null;
            tail = null;
            size = 0;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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
                T data = currentNode.data;
                return data;
            }
            count++;
            currentNode = currentNode.next;
        }
        throw new NoSuchElementException();
    }

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

    public boolean isIndexCorrect(int index) {
        return index >= 0;
    }
}
