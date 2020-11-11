package com.dreadblade.datastructures.stack;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("Stack is empty");
    }
}
