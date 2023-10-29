package common;

public class Node {
    public Object data;
    public Node next, prev;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }

    // Making a Singly Linked List from array
    public static Node getSinglyList(Object[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }

    // Making a Doubly Linked List from array
    public static Node getDoublyList(Object[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        return head;
    }

    // Making a Singly Circular Linked List from array
    public static Node getSinglyCircularList(Object[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            tail.next = node;
            tail = tail.next;
        }
        tail.next = head;
        return head;
    }

    // Making a Doubly Circular Linked List from array
    public static Node getDoublyCircularList(Object[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        tail.next = head;
        head.prev = tail;
        return head;
    }
}
