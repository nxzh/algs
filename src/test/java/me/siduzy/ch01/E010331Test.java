package me.siduzy.ch01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static me.siduzy.ch01.sec03.E010331.*;

public class E010331Test {


    public DoubleNode<Integer> createList(int size) {
        @SuppressWarnings("unchecked")
        DoubleNode<Integer>[] ary = (DoubleNode<Integer>[]) (new DoubleNode[size]);
        for (int i = 0; i < ary.length; i++) {
            ary[i] = new DoubleNode<>();
        }
        for (int i = 0; i < ary.length; i++) {
            ary[i].data = i;
            ary[i].prev = i == 0 ? null : ary[i - 1];
            ary[i].next = i == ary.length - 1 ? null : ary[i + 1];
        }
        return ary[0];
    }

    public void print(DoubleNode<?> head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.data).append("->");
            head = head.next;
        }
        builder.append("null");
        System.out.println(builder.toString());
    }

    public int length(DoubleNode<?> head) {
        int n = 0;
        while (head != null) {
            head = head.next;
            ++n;
        }
        return n;
    }

    @Test
    public void testRemoveHead() {
        DoubleNode<Integer> resRemoveEmptyHead = removeHead(null);
        Assertions.assertNull(resRemoveEmptyHead);

        DoubleNode<Integer> list = createList(1);
        DoubleNode<Integer> resRemoveSingleHead = removeHead(list);
        Assertions.assertNull(resRemoveSingleHead);

        list = createList(2);
        DoubleNode<Integer> resRemoveMultipleHead = removeHead(list);
        Assertions.assertEquals(1, length(resRemoveMultipleHead));
        Assertions.assertEquals(1, resRemoveMultipleHead.data);
    }

    @Test
    public void testRemoveTail() {
        DoubleNode<Integer> resRemoveEmptyTail = removeTail(null);
        Assertions.assertNull(resRemoveEmptyTail);

        DoubleNode<Integer> list = createList(1);
        DoubleNode<Integer> resRemoveSingleList = removeTail(list);
        Assertions.assertNull(resRemoveSingleList);

        list = createList(2);
        DoubleNode<Integer> resRemoveMultiple = removeTail(list);
        Assertions.assertEquals(1, length(resRemoveMultiple));
        Assertions.assertEquals(0, resRemoveMultiple.data);
    }

    @Test
    public void testInsertBeforeHead() {
        DoubleNode<Integer> list = createList(1);
        DoubleNode<Integer> res = insertBeforeHead(list, 1);
        Assertions.assertEquals(2, length(res));
        Assertions.assertEquals(1, res.data);

        res = insertBeforeHead(res, 2);
        Assertions.assertEquals(3, length(res));
        Assertions.assertEquals(2, res.data);

        res = insertBeforeHead(null, 0);
        Assertions.assertEquals(1, length(res));
        Assertions.assertEquals(0, res.data);
    }

    @Test
    public void testInsertAfterTail() {
        DoubleNode<Integer> res = insertAfterTail(null, 0);
        Assertions.assertEquals(0, res.data);
        res = insertAfterTail(res, 1);
        Assertions.assertEquals(2, length(res));
        Assertions.assertEquals(0, res.data);
        res = insertAfterTail(res, 2);
        Assertions.assertEquals(3, length(res));
        Assertions.assertEquals(0, res.data);
    }

    @Test
    public void testInsertBefore() {
        DoubleNode<Integer> list = createList(3);
        DoubleNode<Integer> res = insertBefore(list, 0, -1);
        print(res);
        Assertions.assertEquals(-1, res.data);
        Assertions.assertEquals(4, length(res));
        res = insertBefore(res, 2, 1);
        print(res);
        Assertions.assertEquals(5, length(res));
        Assertions.assertEquals(1, res.next.next.data);
        res = insertBefore(res, 3, 0);
        print(res);
        Assertions.assertEquals(5, length(res));
    }

    @Test
    public void testInsertAfter() {
        DoubleNode<Integer> list = createList(3);
        DoubleNode<Integer> res = insertAfter(list, 0, 1);
        print(res);
        Assertions.assertEquals(4, length(res));
        Assertions.assertEquals(1, res.next.data);
        res = insertAfter(res, 2, 3);
        print(res);
        Assertions.assertEquals(5, length(res));
        Assertions.assertEquals(1, res.next.data);
        res = insertAfter(list, 10, 3);
        print(res);
        Assertions.assertEquals(2, res.next.next.next.data);
        Assertions.assertEquals(5, length(res));
    }
}
