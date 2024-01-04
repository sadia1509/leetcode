package dsa.datastructure.linear;

import common.*;

public class LinkedList {

    public void printSinglyList(ListNode head) {
        Logs.print("Singly linked list: ");
        for (ListNode n = head; n != null; n = n.next)
            Logs.print(n.data + " ");
        Logs.lineBreak(1);
    }

    public void printDoublyList(ListNode head) {
        Logs.print("Singly doubly linked list: ");
        for (ListNode n = lastNode(head); n != null; n = n.prev)
            Logs.print(n.data + " ");
        Logs.lineBreak(1);
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
            Logs.print(n.data + " ");
            n = n.next;
        } while (n != head);
        Logs.lineBreak(1);
    }

    public void printDoublyCircularList(ListNode head) {
        Logs.print("Singly doubly circular linked list: ");
        ListNode n = lastNode(head);
        do {
            Logs.print(n.data + " ");
            n = n.prev;
        } while (n != head.prev);
        Logs.lineBreak(1);
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

    // Check if a linked list is Circular Linked List
    public boolean isCircular(ListNode head) {
        ListNode m = head.next;
        while (m != head && m != null) m = m.next;
        return (m == head);
    }

    //Reverse Singly Linked list
    public ListNode reverseList(ListNode head) {  //10,4,5,3,6
        if (head == null) return head;
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    // For now only LinkedList
    public void removeElements(ListNode head, Object val) {
        while (head != null && head.data == val) head = head.next;

        if (head == null) return;
        ListNode n = head.next, prev = head;
        while (n != null) {
            if (n.data == val) {
                prev.next = n.next;
                n = n.next;
                continue;
            }
            prev = prev.next;
            n = n.next;
        }
        printSinglyList(head);
    }

}
