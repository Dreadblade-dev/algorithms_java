package com.dreadblade.datastructures.list;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 */
public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("List is empty");
    }
}
