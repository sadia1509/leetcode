package leetcode.medium;

import common.*;

public class ListProblems {
    //Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode head, tail, n = l1, m = l2;
        int temp = (int) n.data + (int) m.data;
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
            temp = (int) n.data + (int) m.data + additional;
            ListNode node = new ListNode(temp % 10);
            additional = temp / 10;
            tail.next = node;
            tail = tail.next;
            n = n.next;
            m = m.next;
        }

        if (l2Smaller) {
            while (n != null) {
                temp = (int) n.data + additional;
                ListNode node = new ListNode(temp % 10);
                additional = temp / 10;
                tail.next = node;
                tail = tail.next;
                n = n.next;
            }
        } else {
            while (m != null) {
                temp = (int) m.data + additional;
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

    //Count Nodes Equal to Average of Subtree
    int counter = 0;

    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeHelper(root);
        return counter;
    }

    public int[] averageOfSubtreeHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = averageOfSubtreeHelper(root.left);
        int[] right = averageOfSubtreeHelper(root.right);
        int sum = left[0] + (int) root.value + right[0];
        int total = left[1] + 1 + right[1];
        if (sum / total == (int) root.value) counter++;
        return new int[]{sum, total};
    }
}
