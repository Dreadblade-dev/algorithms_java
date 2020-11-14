package com.dreadblade.utils;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 */
public class IndexOutOfBoundsException extends RuntimeException {
    public IndexOutOfBoundsException() {
        super("Index out of bounds");
    }

    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}
