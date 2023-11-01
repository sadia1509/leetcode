package leetcode.easy;

import common.*;
import dsa.datastructure.linear.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListProblems {
    LinkedList linkedList = new LinkedList();

    //Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        int middleLength = linkedList.count(head) / 2;
        ListNode temp = head;
        for (int i = 0; i < middleLength; i++) temp = temp.next;
        return temp;
    }

    //Detect loop in a linked list
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

}
