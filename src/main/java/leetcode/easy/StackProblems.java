package leetcode.easy;

import common.*;
import java.util.*;

public class StackProblems {
    Stack<Object> stack = new Stack<>();
    Stack<Object> tempStack = new Stack<>();
    int size = 0;

    public void push(int elem) {
        size++;
        while (!stack.isEmpty()) tempStack.push(stack.pop());
        stack.push(elem);
        while (!tempStack.isEmpty()) stack.push(tempStack.pop());

    }

    public Object pop() {
        size--;
        return stack.pop();
    }

    public Object peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    //Implement Queue using Stacks
    public void queueUsingStack() {
        push(1);
        push(2);
        push(3);
        push(4);
        Logs.println(pop());
        Logs.println(pop());
        Logs.println(pop());
        Logs.println(pop());
    }

}
