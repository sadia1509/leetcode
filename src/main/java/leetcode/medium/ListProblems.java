package leetcode.medium;

import common.*;
import dsa.datastructure.linear.LinkedList;

import java.math.BigInteger;
import java.util.*;

public class ListProblems {
    LinkedList linkedList = new LinkedList();

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
        List<List<Integer>> list = new java.util.LinkedList<>();
        subsets(0, nums, new ArrayList<>(), list);
        return list;
    }

    private void subsets(int i, int[] nums, ArrayList<Integer> temp, List<List<Integer>> list) {
        if (i >= nums.length) {
            list.add(new java.util.LinkedList<>(temp));
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

    // Insertion Sort List
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-5001);
        dummyHead.next = head;
        ListNode prev = head, cur = head.next;
        while (cur != null) {
            if (cur.val >= prev.val) {
                prev = cur;
                cur = cur.next;
                continue;
            }
            ListNode temp = dummyHead;
            while (cur.val > temp.next.val)
                temp = temp.next;
            prev.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = prev.next;
        }
        return dummyHead.next;
    }

    // Double a Number Represented as a Linked List
    public ListNode doubleIt(ListNode head) {
        if (head == null) return head;
        StringBuilder sb = new StringBuilder();
        for (ListNode n = head; n != null; n = n.next)
            sb.append(n.val);
        BigInteger num = new BigInteger(sb.toString()).multiply(BigInteger.TWO);
        if (num.equals(BigInteger.ZERO)) return new ListNode(0);
        ListNode tail = null;
        while (!num.equals(BigInteger.ZERO)) {
            ListNode node = new ListNode(num.mod(BigInteger.TEN).intValue());
            node.next = tail;
            tail = node;
            num = num.divide(BigInteger.TEN);
        }
        return tail;
    }

    // Remove Nodes From Linked List
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<Integer> stack = new Stack<>();
        for (ListNode n = head; n != null; n = n.next) {
            while (!stack.isEmpty() && stack.peek() < n.val)
                stack.pop();
            stack.push(n.val);
        }
        ListNode newHead = null, tail = null;
        for (int elem : stack) {
            if (newHead == null) {
                newHead = new ListNode(elem);
                tail = newHead;
                continue;
            }
            tail.next = new ListNode(elem);
            tail = tail.next;
        }
        return newHead;
    }

    // Swapping Nodes in a Linked List
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode firstNode = null, lastNode = head;
        ListNode prev1 = null, prev2 = null;
        int count = 0;
        for (ListNode n = head; n != null; n = n.next) {
            count++;
            if (count == k - 1) prev1 = n;
            if (count == k) firstNode = n;
        }
        for (int i = 0; i < count - k; i++) {
            prev2 = lastNode;
            lastNode = lastNode.next;
        }
        if (k == 1) {
            prev2.next = firstNode;
            ListNode temp = firstNode.next;
            firstNode.next = null;
            lastNode.next = temp;
            return lastNode;
        } else if (count == k) {
            prev1.next = lastNode;
            ListNode temp = lastNode.next;
            lastNode.next = null;
            firstNode.next = temp;
            return firstNode;
        } else if (count % 2 == 0 && count / 2 == k - 1) {
            prev2.next = firstNode;
            ListNode temp = firstNode.next;
            firstNode.next = lastNode;
            lastNode.next = temp;
            return head;
        } else {
            prev2.next = firstNode;
            ListNode temp = firstNode.next;
            firstNode.next = lastNode.next;
            prev1.next = lastNode;
            lastNode.next = temp;
            return head;
        }
    }

    // Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode first = null, second = null;
        ListNode tail1 = null, tail2 = null;
        for (ListNode n = head; n != null; n = n.next) {
            if (count % 2 == 0) {
                if (first == null) {
                    first = n;
                    tail1 = first;
                } else {
                    tail1.next = n;
                    tail1 = tail1.next;
                }
            } else {
                if (second == null) {
                    second = n;
                    tail2 = second;
                } else {
                    tail2.next = n;
                    tail2 = tail2.next;
                }
            }
            count++;
        }
        tail1.next = second;
        if (count % 2 != 0) tail2.next = null;
        return head;
    }

    // Merge In Between Linked Lists
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode n = list1, prev = null;
        while (n != null) {
            if (index == a - 1) prev = n;
            else if (index == b + 1) {
                ListNode temp = n;
                prev.next = list2;
                ListNode m = list2;
                while (m.next != null) m = m.next;
                m.next = temp;
            }
            index++;
            n = n.next;
        }
        return list1;
    }

    // Maximum Twin Sum of a Linked List
    public int pairSum(ListNode head) {
        ListNode reversed = linkedList.reversedList(linkedList.copyList(head));
        ListNode reversedSlow = reversed, slow = head, fast = head;
        Set<Integer> sums = new HashSet<>();
        while (fast != null && fast.next != null) {
            sums.add(slow.val + reversedSlow.val);
            reversedSlow = reversedSlow.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        int max = 0;
        for (int s : sums) max = Math.max(max, s);
        return max;
    }

    // Delete the Middle Node of a Linked List
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    // Sort List
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middleNode = linkedList.getMiddleNode(head);
        ListNode nextMiddleNode = middleNode.next;
        middleNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextMiddleNode);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val <= right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    // Reorder List
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next)
            list.add(n);
        int count = list.size() / 2, index = list.size() - 1;
        ListNode n = head;
        for (; n != null && count > 0; n = n.next) {
            ListNode temp = n.next;
            n.next = list.get(index--);
            n.next.next = temp;
            n = n.next;
            count--;
        }
        n.next = null;
    }

    // Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        List<ListNode> listNodes = new ArrayList<>();
        for (ListNode n = head; n.next != null; n = n.next) {
            if (listNodes.contains(n)) return n;
            listNodes.add(n);
        }
        return null;
    }
}