package com.dreadblade.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackArrayTest {
    @Test
    public void stackCreatesEmpty() {
        StackArray<Integer> stack = new StackArray<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void stackDefaultCapacity()
    {
        StackArray<Integer> stack = new StackArray<>();
        assertEquals(16, stack.getCapacity());
    }

    @Test
    public void stackCustomCapacity()
    {
        StackArray<Integer> stack = new StackArray<>(128);
        assertEquals(128, stack.getCapacity());
    }

    @Test
    public void pushIsCorrect()
    {
        StackArray<Integer> stack = new StackArray<>();
        assertTrue(stack.isEmpty());
        stack.push(128);
        assertFalse(stack.isEmpty());
        stack.push(256);
        stack.push(512);
        stack.push(1024);
        assertEquals(4, stack.getSize());
    }

    @Test
    public void popIsCorrect()
    {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, (int) stack.pop());
        assertEquals(4, stack.getSize());
        assertEquals(4, (int) stack.pop());
        assertEquals(3, stack.getSize());
        assertEquals(3, (int) stack.pop());
        assertEquals(2, stack.getSize());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, stack.getSize());
        assertEquals(1, (int) stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void peekIsCorrect()
    {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(128);
        assertEquals(1, stack.getSize());
        assertEquals(128, (int) stack.peek());
        assertEquals(1, stack.getSize());
    }

    @Test (expected = EmptyStackException.class)
    public void clearIsCorrect()
    {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(128);
        stack.push(256);
        stack.push(512);
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
        stack.peek();
    }

    @Test
    public void autoCapacityChangingIsCorrect()
    {
        StackArray<Integer> stack = new StackArray<>();
        for (int i = 0; i <= 16; i++)
        {
            stack.push(i);
        }
        assertEquals(32, stack.getCapacity());

        stack.changeCapacity(128);
        stack.pop();
        assertEquals(64, stack.getCapacity());
        stack.pop();
        assertEquals(32, stack.getCapacity());
    }

}