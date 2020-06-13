package com.dreadblade.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueStackTest {

    @Test
    public void queueStackCreatesEmpty() throws EmptyQueueException {
        QueueStack<Integer> queue = new QueueStack<>();

        assertEquals(0, queue.getSize());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void queueStackClearIsCorrect() {
        QueueStack<Integer> queue = new QueueStack<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void queueStackEnqueueIsCorrect() throws EmptyQueueException {
        QueueStack<Integer> queue = new QueueStack<>();

        assertEquals(0, queue.getSize());
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertEquals(1, queue.getSize());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void queueStackDequeueIsCorrect() throws EmptyQueueException {
        QueueStack<Integer> queue = new QueueStack<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertEquals(1, (int) queue.dequeue());

        queue.enqueue(6);

        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());

        queue.enqueue(7);

        assertEquals(4, (int) queue.dequeue());
        assertEquals(5, (int) queue.dequeue());

        queue.enqueue(8);

        assertEquals(6, (int) queue.dequeue());
        assertEquals(7, (int) queue.dequeue());
        assertEquals(8, (int) queue.dequeue());


        assertTrue(queue.isEmpty());
    }

    @Test
    public void queueStackFrontIsCorrect() throws EmptyQueueException {
        QueueStack<Integer> queue = new QueueStack<>();

        queue.enqueue(128);
        assertEquals(128, (int) queue.front());
        queue.enqueue(256);
        assertEquals(128, (int) queue.front());
    }
}