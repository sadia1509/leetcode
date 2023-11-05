package leetcode.easy;

import java.util.*;

public class QueueProblems {
    Queue<Object> queue = new LinkedList<>();
    int size = 0;

    void push(Object elem) {
        queue.add(elem);
        size++;
        for (int i = 0; i < size - 1; i++) queue.add(queue.remove());
    }

    Object pop() {
        size--;
        return queue.poll();
    }

    Object peek() {
        return queue.peek();
    }

    boolean empty() {
        return queue.isEmpty();
    }

    //Implement Stack using Queues
    public void stackUsingQueue() {
        push(1);
        push(2);
        push(7);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
