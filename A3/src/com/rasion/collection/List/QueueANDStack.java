package com.rasion.collection.List;

import java.util.LinkedList;

public class QueueANDStack {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        //入队
        queue.addFirst("1");
        queue.addLast("2");
        queue.addFirst("3");
        queue.addLast("4");
        System.out.println(queue);
        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeLast());
        System.out.println(queue);

        LinkedList<String> stack = new LinkedList<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
