package leetcode.hard;

import common.*;

public class ListProblems {
    // Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int count = 0;
        ListNode c = head;
        while (c != null) {
            count++;
            c = c.next;
        }
        count = count / k;
        ListNode[] hlr = reverseKGroupHelper(head, k);
        head = hlr[0];
        ListNode n = hlr[2], temp = hlr[1];
        while (count-- != 1) {
            hlr = reverseKGroupHelper(n, k);
            if (hlr.length == 0) break;
            temp.next = hlr[0];
            n = hlr[2];
            temp = hlr[1];
        }
        return head;
    }

    private ListNode[] reverseKGroupHelper(ListNode head, int k) {
        if (head == null || k == 0) return new ListNode[]{};
        ListNode n = head, prev = null;
        while (n != null) {
            if (k-- == 0) break;
            ListNode next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        head.next = n;
        return new ListNode[]{prev, head, n};
    }

    // Merge k Sorted Lists
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode tempHead;
        if (len == 0) return null;
        else tempHead = lists[0];
        for (int i = 1; i < len; i++)
            tempHead = merge(tempHead, lists[i]);

        return tempHead;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) return null;
        ListNode nl = left, ml = right, head;
        if (left == null) {
            head = new ListNode(ml.data);
            ml = ml.next;
        } else if (right == null) {
            head = new ListNode(nl.data);
            nl = nl.next;
        } else {
            if ((int) nl.data > (int) ml.data) {
                head = new ListNode(ml.data);
                ml = ml.next;
            } else {
                head = new ListNode(nl.data);
                nl = nl.next;
            }
        }
        ListNode tail = head;
        while (nl != null && ml != null) {
            if ((int) nl.data > (int) ml.data) {
                tail.next = new ListNode(ml.data);
                ml = ml.next;
            } else {
                tail.next = new ListNode(nl.data);
                nl = nl.next;
            }
            tail = tail.next;
        }
        while (nl != null) {
            tail.next = new ListNode(nl.data);
            tail = tail.next;
            nl = nl.next;
        }
        while (ml != null) {
            tail.next = new ListNode(ml.data);
            tail = tail.next;
            ml = ml.next;
        }
        return head;
    }
}
