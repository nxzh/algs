package me.siduzy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedStackTest {
    @Test
    public void testPop_whenEmpty_thenThrowsNoSuchElementException() {
        LinkedStack<Integer> stk = new LinkedStack<>();
        stk.push(1);
        stk.pop();
        Assertions.assertThrows(NoSuchElementException.class, () -> stk.pop());
    }

    @Test
    public void testPush_whenResize() {
        LinkedStack<Integer> stk = new LinkedStack<>();
        for (int i = 0; i < 100; ++i) {
            stk.push(i);
        }
        Assertions.assertTrue(stk.size() == 100);
    }

    @Test
    public void testPop_whenResizeAndPop() {
        LinkedStack<Integer> stk = new LinkedStack<>();
        for (int i = 0; i < 100; ++i) {
            stk.push(i);
        }
        for (int i = 0; i < 100; ++i) {
            Assertions.assertFalse(stk.isEmpty());
            stk.pop();
        }
        Assertions.assertTrue(stk.isEmpty());
        Assertions.assertThrows(NoSuchElementException.class, () -> stk.pop());
    }

    @Test
    public void testIterator() {
        Stack<Integer> stk = new LinkedStack<>();
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
