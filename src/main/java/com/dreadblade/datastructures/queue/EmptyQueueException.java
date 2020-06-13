package com.dreadblade.datastructures.queue;

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Queue is empty");
    }
}
