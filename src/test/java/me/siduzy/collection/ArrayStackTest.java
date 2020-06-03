package me.siduzy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayStackTest {
    @Test
    public void testPop_whenEmpty_thenThrowsNoSuchElementException() {
        ArrayStack<Integer> stk = new ArrayStack<>();
        stk.push(1);
        stk.pop();
        Assertions.assertThrows(NoSuchElementException.class, () -> stk.pop());
    }

    @Test
    public void testPush_whenResize() {
        ArrayStack<Integer> stk = new ArrayStack<>();
        for (int i = 0; i < 100; ++i) {
            stk.push(i);
        }
        assertTrue(stk.size() == 100);
    }

    @Test
    public void testPop_whenResizeAndPop() {
        ArrayStack<Integer> stk = new ArrayStack<>();
        for (int i = 0; i < 100; ++i) {
            stk.push(i);
        }
        for (int i = 0; i < 100; ++i) {
            Assertions.assertFalse(stk.isEmpty());
            stk.pop();
        }
        assertTrue(stk.isEmpty());
        Assertions.assertThrows(NoSuchElementException.class, () -> stk.pop());
    }

    @Test
    public void testIterator() {
        Stack<Integer> stk = new ArrayStack<>();
        for (int i = 0; i < 100; ++i) {
            stk.push(i);
        }
        Iterator<Integer> iter = stk.iterator();
        int count = 0;
        while (iter.hasNext()) {
            iter.next();
            count ++;
        }
        assertTrue(count == 100);
    }
}
