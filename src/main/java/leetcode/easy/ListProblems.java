package leetcode.easy;

import common.*;
import dsa.datastructure.linear.LinkedList;

import java.util.*;

public class ListProblems {
    LinkedList linkedList = new LinkedList();

    // Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        int middleLength = linkedList.count(head) / 2;
        ListNode temp = head;
        for (int i = 0; i < middleLength; i++) temp = temp.next;
        return temp;
    }

    // Detect loop in a linked list
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        List<ListNode> listNodes = new ArrayList<>();
        ListNode n;
        for (n = head; n.next != head && n.next != null; n = n.next) {
            if (listNodes.contains(n)) return true;
            listNodes.add(n);
        }
        return n.next == head;
    }

    // Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        List<Object> list = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) list.add(n.data);
        int l = 0, r = list.size() - 1;
        while (l < r)
            if (!list.get(l++).equals(list.get(r--))) return false;
        return true;
    }

    // Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
        Logs.println(node);
    }

    // Determine Color of a Chessboard Square
    public boolean squareIsWhite(String coordinates) {
        List<Character> startB = Arrays.asList('a', 'c', 'e', 'g');
        char ch = coordinates.charAt(0);
        int num = coordinates.charAt(1) - '0';
        if (startB.contains(ch)) {
            return num % 2 == 0;
        } else return num % 2 != 0;
    }
}
