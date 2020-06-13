package com.dreadblade.datastructures.queue;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 * Implementing a queue using two stacks
 *
 * In computer science, a queue is a collection of entities that are
 * maintained in a sequence and can be modified by the addition of
 * entities at one end of the sequence and the removal of entities from
 * the other end of the sequence.
 *
 * Time complexity:
 * ┌───────────┬───────────┬──────────┐
 * │           │ Insertion │ Deletion │
 * ├───────────┼───────────┼──────────┤
 * │Best case: │    O(1)   │   O(1)   │
 * ├───────────┼───────────┼──────────┤
 * │ Average:  │    O(n)   │   O(1)   │
 * ├───────────┴───────────┴──────────┤
 * │Worst case:│    O(n)   │   O(1)   │
 * └───────────┴───────────┴──────────┘
 *
 * Source: https://en.wikipedia.org/wiki/Queue_(abstract_data_type)
 */


import com.dreadblade.datastructures.stack.Stack;
import com.dreadblade.datastructures.stack.StackArray;

public class QueueStack<T> implements Queue<T> {
    Stack<T> front;
    Stack<T> back;

    /**
     * QueueStack default constructor
     */
    public QueueStack() {
        this.front = new StackArray<>();
        this.back = new StackArray<>();
    }

    /**
     * @return <code>true</code> if QueueStack is empty
     */
    @Override
    public boolean isEmpty() {
        return (front.isEmpty() && back.isEmpty());
    }

    /**
     * @return QueueStack <code>int size</code>
     */
    @Override
    public int getSize() {
        return front.getSize() + back.getSize();
    }

    /**
     * Clears the QueueStack
     */
    @Override
    public void clear() {
        front.clear();
        back.clear();
    }

    /**
     * Adds an item to the end of the QueueStack
     * @param item <code>T item</code> to be added
     */
    @Override
    public void enqueue(T item) {
        while (!front.isEmpty())
            back.push(front.pop());

        back.push(item);

        while (!back.isEmpty())
            front.push(back.pop());
    }

    /**
     * Returns and delete an item from the beginning of the QueueStack
     * @return <code>T item</code> from the beginning of the QueueStack
     * @throws EmptyQueueException
     */
    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return front.pop();
    }

    /**
     * Returns an item from the beginning of the QueueStack
     * @return <code>T item</code> from the beginning of the QueueStack
     * @throws EmptyQueueException
     */
    @Override
    public T front() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return front.peek();
    }
}
