package leetcode.medium;

import java.util.*;

public class StackProblems {
    // Build an Array With Stack Operations
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack();
        List<String> operations = new ArrayList<>();
        int val = 1, i = 0;
        while (val <= n && i < target.length) {
            stack.push(val);
            operations.add("Push");
            if (target[i] != val) {
                stack.pop();
                operations.add("Pop");
            } else i++;
            val++;
        }
        return operations;
    }
}
