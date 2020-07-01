package me.siduzy.ch01.sec03;

public class E010331 {
    static class DoubleNode<Item> {
        DoubleNode<Item> prev;
        DoubleNode<Item> next;
        Item data;
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
        DoubleNode<Item> oldHead = head;
        DoubleNode<Item> newHead = oldHead.next;
        oldHead.next = null;
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
        if (targetNode != null) {
            targetNode.prev = node;
        }
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

    public static DoubleNode<Integer> createList(int size) {
        DoubleNode<Integer>[] ary = new DoubleNode[size];
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

    public static void print(DoubleNode<?> head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.data).append("->");
            head = head.next;
        }
        builder.append("null");
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        DoubleNode<Integer> list = createList(1);
        DoubleNode<Integer> result = insertAfter(list, 0, 10);
        print(result);
    }

}
