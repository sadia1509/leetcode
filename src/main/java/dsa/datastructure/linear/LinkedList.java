package dsa.datastructure.linear;

import common.*;

public class LinkedList {

    public void printSinglyList(ListNode head) {
        Logs.print("Singly linked list: ");
        for (ListNode n = head; n != null; n = n.next)
            System.out.print(n.data + " ");
        System.out.println();
    }

    public void printDoublyList(ListNode head) {
        Logs.print("Singly doubly linked list: ");
        for (ListNode n = lastNode(head); n != null; n = n.prev)
            System.out.print(n.data + " ");
        System.out.println();
    }

    public ListNode lastNode(ListNode head) {
        ListNode n = head.next;
        while (n.next != head && n.next != null) n = n.next;
        return n;
    }

    public void printSinglyCircularList(ListNode head) {
        Logs.print("Singly circular linked list: ");
        ListNode n = head;
        do {
            System.out.print(n.data + " ");
            n = n.next;
        } while (n != head);
        System.out.println();
    }

    public void printDoublyCircularList(ListNode head) {
        Logs.print("Singly doubly circular linked list: ");
        ListNode n = lastNode(head);
        do {
            System.out.print(n.data + " ");
            n = n.prev;
        } while (n != head.prev);
        System.out.println();
    }

    private void print(ListNode head) {
        if (isCircular(head)) printSinglyCircularList(head);
        else printSinglyList(head);
    }

    private void printDoubly(ListNode head) {
        if (isCircular(head)) {
            printSinglyCircularList(head);
            printDoublyCircularList(head);
        } else {
            printSinglyList(head);
            printDoublyList(head);
        }
    }

    // Insert an element based on index (both for linear and circular)
    public void insert(ListNode head, Object elem, int index) {
        ListNode node = new ListNode(elem);
        if (index == 0) {
            node.next = head;
            if (isCircular(head)) {
                ListNode lastNode = lastNode(head);
                lastNode.next = node;
            }
            head = node;
        } else {
            ListNode temp = get(head, index - 1);
            if (temp == null) {
                Logs.print("Invalid Index!!!");
                return;
            }
            node.next = temp.next;
            temp.next = node;
        }
        print(head);
    }

    public void insert(ListNode head, Object elem) {
        ListNode node = new ListNode(elem);
        if (head == null) head = node;
        else {
            ListNode temp = lastNode(head);
            node.next = temp.next;
            temp.next = node;
        }
        print(head);
    }

    // Delete an element based on index (both for linear and circular)
    public void delete(ListNode head, int index) {
        if (index == 0) {
            if (isCircular(head)) {
                ListNode lastNode = lastNode(head);
                lastNode.next = head.next;
            }
            head = head.next;
        } else {
            ListNode temp = get(head, index - 1);
            if (temp == null || temp.next == null || temp.next == head) {
                Logs.print("Invalid Index!!!");
                return;
            }
            temp.next = temp.next.next;
        }
        print(head);
    }

    // Insert an element based on index (both for linear and circular) for doubly
    public void insertDoubly(ListNode head, Object elem, int index) {
        ListNode node = new ListNode(elem);
        if (index == 0) {
            node.next = head;
            head.prev = node;
            if (isCircular(head)) {
                ListNode last = lastNode(head);
                last.next = node;
                node.prev = last;
            }
            head = node;
        } else {
            ListNode temp = get(head, index - 1);
            if (temp == null) {
                Logs.print("Invalid Index!!!");
                return;
            }
            node.prev = temp;
            node.next = temp.next;
            if (temp.next != null) temp.next.prev = node;
            temp.next = node;
        }

        printDoubly(head);
    }

    public void insertDoubly(ListNode head, Object elem) {
        ListNode node = new ListNode(elem);
        if (head == null) head = node;
        else {
            ListNode temp = lastNode(head);
            node.prev = temp;
            node.next = temp.next;
            temp.next = node;
            if (isCircular(head)) head.prev = node;
        }
        printDoubly(head);
    }

    // Delete an element based on index (both for linear and circular) for doubly
    public void deleteDoubly(ListNode head, int index) {
        if (index == 0) {
            if (isCircular(head)) {
                ListNode last = lastNode(head);
                last.next = head.next;
                last.next.prev = last;
            }
            head.next.prev = head.prev;
            head = head.next;
        } else {
            ListNode temp = get(head, index - 1);
            if (temp == null || temp.next == null || temp.next == head) {
                Logs.print("Invalid Index!!!");
                return;
            }
            temp.next = temp.next.next;
            if (temp.next != null) temp.next.prev = temp;
        }
        printDoubly(head);
    }

    // i-th node
    public ListNode get(ListNode head, int index) {
        if (index + 1 > count(head)) return null; //this line is for internal logic convenience, not mandatory.
        ListNode n = head;
        for (int i = 0; i < index; i++) {
            if (n == null) break;
            n = n.next;
        }
        return n;
    }

    // Total element counter
    public int count(ListNode head) {
        ListNode m = head.next;
        int count = 1;
        while (m != head && m != null) {
            m = m.next;
            count++;
        }
        return count;
    }

    //Check if a linked list is Circular Linked List
    public boolean isCircular(ListNode head) {
        ListNode m = head.next;
        while (m != head && m != null) m = m.next;
        return (m == head);
    }

}
