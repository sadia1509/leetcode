package common;

public class ListNode {
    public Object data;
    public ListNode next, prev;

    public ListNode(Object data) {
        this.data = data;
    }

    public ListNode(Object data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data, ListNode next, ListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
//                ", next=" + next +
//                ", prev=" + prev +
                '}';
    }

    // Making a Singly Linked List from array
    public static ListNode getSinglyList(Object[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }

    // Making a Doubly Linked List from array
    public static ListNode getDoublyList(Object[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        return head;
    }

    // Making a Singly Circular Linked List from array
    public static ListNode getSinglyCircularList(Object[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            tail.next = node;
            tail = tail.next;
        }
        tail.next = head;
        return head;
    }

    // Making a Doubly Circular Linked List from array
    public static ListNode getDoublyCircularList(Object[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        tail.next = head;
        head.prev = tail;
        return head;
    }
}
