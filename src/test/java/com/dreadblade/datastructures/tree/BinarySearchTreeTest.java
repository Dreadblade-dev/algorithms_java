package com.dreadblade.datastructures.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void binarySearchTreeCreatesEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        assertTrue(tree.isEmpty());
        assertEquals(Integer.valueOf(0), Integer.valueOf(tree.size()));
    }

    @Test
    public void binarySearchTreeAddIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        assertFalse(tree.isEmpty());
        assertTrue(tree.contains(1));
        assertEquals(Integer.valueOf(1), Integer.valueOf(tree.size()));
    }

    @Test
    public void binarySearchTreeRemoveIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        assertEquals(Integer.valueOf(3), Integer.valueOf(tree.size()));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        tree.remove(3);
        assertFalse(tree.contains(3));
        tree.remove(2);
        assertFalse(tree.contains(2));
        tree.remove(1);
        assertFalse(tree.contains(1));
        assertEquals(Integer.valueOf(0), Integer.valueOf(tree.size()));
        assertTrue(tree.isEmpty());
    }

    @Test(expected = EmptyTreeException.class)
    public void binarySearchTreeHeightIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.height();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        assertEquals(Integer.valueOf(3), Integer.valueOf(tree.height()));
    }

    @Test
    public void binarySearchTreeClearIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(2);
        tree.add(1);
        tree.add(3);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertEquals(Integer.valueOf(3), Integer.valueOf(tree.size()));
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
        assertEquals(Integer.valueOf(0), Integer.valueOf(tree.size()));
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(3));
    }

    @Test
    public void binarySearchTreePreOrderTraversalIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        Iterator<Integer> iterator = tree.preOrderTraversal();

        assertTrue(iterator.hasNext());

        assertEquals(Integer.valueOf(6), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(8), iterator.next());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertEquals(Integer.valueOf(9), iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void binarySearchTreeInOrderTraversalIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        Iterator<Integer> iterator = tree.inOrderTraversal();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(6), iterator.next());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertEquals(Integer.valueOf(8), iterator.next());
        assertEquals(Integer.valueOf(9), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void binarySearchTreePostOrderTraversalIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        Iterator<Integer> iterator = tree.postOrderTraversal();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertEquals(Integer.valueOf(9), iterator.next());
        assertEquals(Integer.valueOf(8), iterator.next());
        assertEquals(Integer.valueOf(6), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void binarySearchTreeLevelOrderTraversalIsCorrect() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        Iterator<Integer> iterator = tree.levelOrderTraversal();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(6), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
        assertEquals(Integer.valueOf(8), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertEquals(Integer.valueOf(9), iterator.next());
        assertFalse(iterator.hasNext());
    }
}