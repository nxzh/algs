package me.siduzy.ch01.sec03;

import edu.princeton.cs.algs4.In;

public class E010331 {
    public static class DoubleNode<Item> {
        public DoubleNode<Item> prev;
        public DoubleNode<Item> next;
        public Item data;
    }

    public static <Item> DoubleNode<Item> insertBeforeHead(DoubleNode<Item> head, Item data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not allowed to be null");
        }
        DoubleNode<Item> oldHead = head;
        head = new DoubleNode<>();
        head.data = data;
        head.prev = null;
        head.next = oldHead;
        if (oldHead != null) {
            oldHead.prev = head;
        }
        return head;
    }

    public static <Item> DoubleNode<Item> insertAfterTail(DoubleNode<Item> head, Item data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not allowed to be null");
        }
        DoubleNode<Item> dummy = new DoubleNode<>();
        dummy.next = head;

        DoubleNode<Item> oldTail = dummy;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }

        DoubleNode<Item> newTail = new DoubleNode<>();
        newTail.data = data;
        oldTail.next = newTail;
        if (oldTail != dummy) {
            newTail.prev = oldTail;
        }
        return dummy.next;
    }

    public static <Item> DoubleNode<Item> removeHead(DoubleNode<Item> head) {
        if (head == null) {
            return null;
        }
        DoubleNode<Item> newHead = head.next;
        head.next = null;
        if (newHead != null) {
            newHead.prev = null;
        }
        return newHead;
    }

    public static <Item> DoubleNode<Item> removeTail(DoubleNode<Item> head) {
        if (head == null || head.next == null) {
            return null;
        }
        DoubleNode<Item> oldTail = head;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }
        oldTail.prev.next = null;
        oldTail.prev = null;
        return head;
    }

    public static <Item> DoubleNode<Item> insertBefore(DoubleNode<Item> head, Item target, Item toIns) {
        if (toIns == null) {
            throw new IllegalArgumentException("data to insert is not allowed to be null");
        }
        if (target == null) {
            throw new IllegalArgumentException("target is not allowed to be null");
        }
        DoubleNode<Item> dummy = new DoubleNode<>();
        dummy.next = head;
        DoubleNode<Item> targetNode = head;
        DoubleNode<Item> prevTarget = dummy;
        boolean found = false;
        while (targetNode != null) {
            if (targetNode.data.equals(target)) {
                found = true;
                break;
            }
            prevTarget = targetNode;
            targetNode = targetNode.next;
        }
        if (!found) {
            return head;
        }
        DoubleNode<Item> node = new DoubleNode<>();
        node.data = toIns;
        prevTarget.next = node;
        if (prevTarget != dummy) {
            node.prev = prevTarget;
        }
        node.next = targetNode;
        targetNode.prev = node;
        return dummy.next;
    }

    public static <Item> DoubleNode<Item> insertAfter(DoubleNode<Item> head, Item target, Item toIns) {
        if (toIns == null) {
            throw new IllegalArgumentException("data to insert is not allowed to be null");
        }
        if (target == null) {
            throw new IllegalArgumentException("target is not allowed to be null");
        }
        DoubleNode<Item> dummy = new DoubleNode<>();
        dummy.next = head;
        DoubleNode<Item> targetNode = dummy;
        boolean found = false;
        while (targetNode.next != null) {
            targetNode = targetNode.next;
            if (target.equals(targetNode.data)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return head;
        }
        DoubleNode<Item> node = new DoubleNode<>();
        node.data = toIns;
        if (targetNode.next != null) {
            node.next = targetNode.next;
            targetNode.next.prev = node;
        }
        targetNode.next = node;
        if (targetNode != dummy) {
            node.prev = targetNode;
        }
        return dummy.next;
    }

    public static <Item> DoubleNode<Item> deleteNode(DoubleNode<Item> head, Item data) {
        if (data == null) {
            return head;
        }
        DoubleNode<Item> toDel = head;
        while (toDel != null && !toDel.data.equals(data)) {
            toDel = toDel.next;
        }
        if (toDel == null) {
            return head;
        }
        if (toDel == head) {
            return removeHead(head);
        }
        toDel.prev.next = toDel.next;
        if (toDel.next != null) {
            toDel.next.prev = toDel.prev;
        }
        toDel.prev = toDel.next = null;
        return head;
    }
}
