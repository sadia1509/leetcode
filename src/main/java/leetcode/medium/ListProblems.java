package leetcode.medium;

import common.*;

public class ListProblems {
    // Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode head, tail, n = l1, m = l2;
        int temp = n.val + m.val;
        int additional = temp / 10;
        head = new ListNode(temp % 10);
        tail = head;
        n = n.next;
        m = m.next;

        boolean l2Smaller = false;
        while (n != null) {
            if (m == null) {
                l2Smaller = true;
                break;
            }
            temp = n.val + m.val + additional;
            ListNode node = new ListNode(temp % 10);
            additional = temp / 10;
            tail.next = node;
            tail = tail.next;
            n = n.next;
            m = m.next;
        }

        if (l2Smaller) {
            while (n != null) {
                temp = n.val + additional;
                ListNode node = new ListNode(temp % 10);
                additional = temp / 10;
                tail.next = node;
                tail = tail.next;
                n = n.next;
            }
        } else {
            while (m != null) {
                temp = m.val + additional;
                ListNode node = new ListNode(temp % 10);
                additional = temp / 10;
                tail.next = node;
                tail = tail.next;
                m = m.next;
            }
        }

        if (additional > 0) {
            ListNode node = new ListNode(additional);
            tail.next = node;
        }

        return head;
    }

    // Insert Greatest Common Divisors in Linked List
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        int i = 1;
        ListNode temp = null;
        for (ListNode n = head; n != null; n = n.next, i++) {
            if (i % 2 == 0) {
                ListNode node = new ListNode(findGCD(temp.val, n.val));
                temp.next = node;
                node.next = n;
                n = temp.next;
            } else temp = n;
        }
        return head;
    }

    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}
