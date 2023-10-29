package dsa.datastructure.linear;

import common.*;

public class LinkedList {

    public void printSinglyList(Node head) {
        Logs.print("Singly linked list: ");
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.data + " ");
        System.out.println();
    }

    public void printDoublyList(Node head) {
        Logs.print("Singly doubly linked list: ");
        for (Node n = lastNode(head); n != null; n = n.prev)
            System.out.print(n.data + " ");
        System.out.println();
    }

    public Node lastNode(Node head) {
        Node n = head.next;
        while (n.next != head && n.next != null) n = n.next;
        return n;
    }

    public void printSinglyCircularList(Node head) {
        Logs.print("Singly circular linked list: ");
        Node n = head;
        do {
            System.out.print(n.data + " ");
            n = n.next;
        } while (n != head);
        System.out.println();
    }

    public void printDoublyCircularList(Node head) {
        Logs.print("Singly doubly circular linked list: ");
        Node n = lastNode(head);
        do {
            System.out.print(n.data + " ");
            n = n.prev;
        } while (n != head.prev);
        System.out.println();
    }

    private void print(Node head) {
        if (isCircular(head)) printSinglyCircularList(head);
        else printSinglyList(head);
    }

    // Insert an element based on index (both for linear and circular)
    public void insert(Node head, Object elem, int index) {
        Node node = new Node(elem);
        if (index == 0) {
            node.next = head;
            if (isCircular(head)) {
                Node lastNode = lastNode(head);
                lastNode.next = node;
            }
            head = node;
        } else {
            Node temp = prevNode(head, index);
            if (temp == null) {
                Logs.print("Invalid Index!!!");
                return;
            }
            node.next = temp.next;
            temp.next = node;
        }
        print(head);
    }

    private Node prevNode(Node head, int index) {
        if (index == 1) return head;
        int count = count(head);
        if (index == count) return lastNode(head);
        else if (index > count) return null;
        else {
            count = 0;
            Node n = head;
            while (n != null) {
                if (index - 1 == count++) return n;
                n = n.next;
            }
        }
        return null;
    }

    public void insert(Node head, Object elem) {
        Node node = new Node(elem);
        if (head == null) head = node;
        else {
            Node temp = lastNode(head);
            node.next = temp.next;
            temp.next = node;
        }
        print(head);
    }

    // Delete an element based on index (both for linear and circular)
    public void delete(Node head, int index) {
        if (index == 0) {
            if (isCircular(head)) {
                Node lastNode = lastNode(head);
                lastNode.next = head.next;
            }
            head = head.next;
        } else {
            Node temp = prevNode(head, index);
            if (temp == null || temp.next == null || temp.next == head) {
                Logs.print("Invalid Index!!!");
                return;
            }
            temp.next = temp.next.next;
        }
        print(head);
    }

    // Total element counter
    public int count(Node head) {
        Node m = head.next;
        int count = 1;
        while (m != head && m != null) {
            m = m.next;
            count++;
        }
        return count;
    }

    //Check if a linked list is Circular Linked List
    public boolean isCircular(Node head) {
        Node m = head.next;
        while (m != head && m != null) m = m.next;
        return (m == head);
    }

}
