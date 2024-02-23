package leetcode.medium;

import common.*;
import java.util.*;

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

    // Partition List
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = null, tempList = null;
        ListNode tail = null, tempTail = null;
        for (ListNode n = head; n != null; n = n.next) {
            ListNode node = new ListNode(n.val);
            if (n.val < x) {
                if (newHead == null) {
                    newHead = node;
                    tail = newHead;
                    continue;
                }
                tail.next = node;
                tail = tail.next;
            } else {
                if (tempList == null) {
                    tempList = node;
                    tempTail = tempList;
                    continue;
                }
                tempTail.next = node;
                tempTail = tempTail.next;
            }
        }
        if (tail != null) tail.next = tempList;
        else newHead = tempList;
        return newHead;
    }

    // Subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        subsets(0, nums, new ArrayList<>(), list);
        return list;
    }

    private void subsets(int i, int[] nums, ArrayList<Integer> temp, List<List<Integer>> list) {
        if (i >= nums.length) {
            list.add(new LinkedList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subsets(i + 1, nums, temp, list);
        temp.remove(temp.size() - 1);
        subsets(i + 1, nums, temp, list);
    }

    // Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        for (ListNode m = head; m != null; m = m.next) list.add(m);
        ListNode deletedNode = list.get(list.size() - n);
        if (deletedNode == head) head = head.next;
        else {
            ListNode m = head;
            while (m != null) {
                if (m.next == deletedNode) m.next = m.next.next;
                m = m.next;
            }
        }
        return head;
    }

    // Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = null;
        int len = 0;
        for (ListNode n = head; n != null; n = n.next) {
            len++;
            if (len == left) start = n;
            if (start != null && len == right) break;
        }
        len = right - left + 1;
        int[] arr = new int[len];
        ListNode m = start;
        for (int i = 0; i < len; i++, m = m.next) arr[i] = m.val;
        for (int i = 0, j = len - 1; i < j; i++, j--)
            Utils.Integer().swap(Utils.intToInteger(arr), i, j);
        ListNode n = start;
        for (int i : arr) {
            n.val = i;
            n = n.next;
        }
        return head;
    }

    // Rotate List
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k %= len;
        if (k == 0) return head;
        int stepsToNewHead = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) newTail = newTail.next;
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
}
