package com.dreadblade.datastructures.queue;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Queue is empty");
    }
}
