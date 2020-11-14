package com.dreadblade.datastructures.tree;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 */
public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        super("Tree is empty");
    }
}
