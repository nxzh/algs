package me.siduzy.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueueTest {

    private void enqueueAll(int from, int to, Queue<Integer> queue) {
        for (int i = from; i < to; ++i) {
            queue.enqueue(i);
        }
    }
    @Test
    public void test() {
        Queue<Integer> queue = new ArrayQueue<>();
        Assertions.assertEquals(0, queue.size());
        enqueueAll(-2, 1000, queue);
        Assertions.assertEquals(1002, queue.size());

        Integer i1 = queue.dequeue();
        Assertions.assertEquals(-2, i1.intValue());
        Integer i2 = queue.dequeue();
        Assertions.assertEquals(-1, i2.intValue());
        enqueueAll(1000, 2000, queue);
        Assertions.assertEquals(2000, queue.size());

        Iterator<Integer> iter = queue.iterator();
        int expectVal = 0;
        while (iter.hasNext()) {
            Integer val = iter.next();
            Assertions.assertEquals(expectVal++, val.intValue());
        }
        expectVal = 0;
        while (expectVal < 2000) {
            Integer val = queue.dequeue();
            Assertions.assertEquals(expectVal++, val);
        }
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}
