package com.dreadblade.datastructures.list;

public class IndexOutOfBoundsException extends RuntimeException {
    public IndexOutOfBoundsException() {
        super("Index out of bounds");
    }

    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}
