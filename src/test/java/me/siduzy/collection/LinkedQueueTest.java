package me.siduzy.collection;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedQueueTest {

    @Test
    public void testLinkedQueue() {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; ++i) {
            queue.enqueue(i);
        }
        assertTrue(queue.size() == 5);
        int value = 0;
        while (!queue.isEmpty()) {
            assertTrue(queue.size() == 5 - value);
            int pop = queue.dequeue();
            assertTrue(pop == value);
            value++;
        }
    }

    @Test
    public void testIterator() {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; ++i) {
            queue.enqueue(i);
        }
        Iterator<Integer> iter = queue.iterator();
        int value = 0;
        while (iter.hasNext()) {
            int i = iter.next();
            assertTrue(i == value);
        }
    }
}
