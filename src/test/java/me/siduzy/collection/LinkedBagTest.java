package me.siduzy.collection;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedBagTest {

    @Test
    public void testBag() {
        Bag bag = new LinkedBag();
        assertTrue(bag.isEmpty());
        for (int i = 0; i < 100; ++i) {
            bag.add(i);
        }
        assertTrue(bag.size() == 100);
        assertFalse(bag.isEmpty());
    }

    @Test
    public void testIterator() {
        Bag<Integer> bag = new LinkedBag<>();
        for (int i = 0; i < 100; ++i) {
            bag.add(i);
        }
        Iterator<Integer> iter = bag.iterator();
        int count = 0;
        while (iter.hasNext()) {
            iter.next();
            count ++;
        }
        assertTrue(count == 100);
    }
}
