package me.siduzy.ch01.sec03;

import me.siduzy.collection.ArrayQueue;
import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.Queue;
import me.siduzy.collection.Stack;

import java.util.Iterator;

public class E010306 {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 3; i++) {
            queue.enqueue(i);
        }
        Stack<Integer> stack = new ArrayStack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while(!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        Iterator<Integer> iter = queue.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
