package com.dreadblade.datastructures.list;

import com.dreadblade.utils.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    @Test(expected = EmptyListException.class)
    public void doublyLinkedListCreatesEmpty() {
        List<Integer> list = new DoublyLinkedList<>();

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        list.get(0);
    }

    @Test(expected = EmptyListException.class)
    public void doublyLinkedListClearIsCorrect() {
        List<Integer> list = new DoublyLinkedList<>();

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        list.get(0);
    }

    @Test
    public void doublyLinkedListAddIsCorrect() {
        List<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        assertEquals(5, list.getSize());
        assertFalse(list.isEmpty());
        for (int i = 0; i < 5; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }

    @Test
    public void doublyLinkedListAddAtIndex() {
        List<Integer> list = new DoublyLinkedList<>();

        list.add(0, 5);
        list.add(1, 5);
        list.add(2, 5);

        assertEquals(Integer.valueOf(0), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
        assertEquals(Integer.valueOf(2), list.get(2));

        list.add(5, 1);
        list.add(6, 1);
        list.add(7, 1);

        assertEquals(Integer.valueOf(7), list.get(1));
        assertEquals(Integer.valueOf(6), list.get(2));
        assertEquals(Integer.valueOf(5), list.get(3));
    }

    @Test
    public void doublyLinkedListRemoveIsCorrect() {
        List<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.getSize());
        list.remove(Integer.valueOf(0));
        assertEquals(4, list.getSize());
        assertEquals(Integer.valueOf(1), list.get(0));

        assertFalse(list.isEmpty());
        for (int i = 0; i < 4; i++) {
            assertEquals(Integer.valueOf(i + 1), list.get(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void doublyLinkedListRemoveAtIndexIsCorrect() {
        List<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.getSize());
        list.remove(5);
        assertEquals(4, list.getSize());
        list.get(5);
        list.remove(0);
        assertEquals(Integer.valueOf(1), list.get(0));

        assertFalse(list.isEmpty());

        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(i + 1), list.get(i));
        }
    }

    @Test
    public void doublyLinkedListGetAtIndexIsCorrect() {
        List<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }

    @Test
    public void doublyLinkedListIndexOfIsCorrect() {
        List<Integer> list = new DoublyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i * i);
        }

        assertEquals(Integer.valueOf(0), Integer.valueOf(list.indexOf(0)));
        assertEquals(Integer.valueOf(2), Integer.valueOf(list.indexOf(4)));
        assertEquals(Integer.valueOf(4), Integer.valueOf(list.indexOf(16)));
    }
}