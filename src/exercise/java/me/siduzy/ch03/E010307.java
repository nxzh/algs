package me.siduzy.ch03;

import me.siduzy.collection.ArrayStack;
import me.siduzy.collection.LinkedStack;
import me.siduzy.collection.Stack;

import java.util.Iterator;

public class E010307 {
    public static void main(String[] args) {
        Stack<Integer> aStack = new ArrayStack<>();
        for (int i = 0; i < 3; i++) {
            aStack.push(i);
        }
        System.out.println(aStack.peek() + aStack.peek());
        Iterator<Integer> iter = aStack.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Stack<Integer> lStack = new LinkedStack<>();
        for (int i = 0; i < 3; i++) {
            lStack.push(i);
        }
        System.out.println(lStack.peek() + lStack.peek());
        Iterator<Integer> iter2 = lStack.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }
}
