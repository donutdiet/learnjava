package com.learnjava.linkedlist;

public class LinkedList {

    public Node head;

    // If you can not figure it out, please refer to video
    // https://www.youtube.com/watch?v=SMIq13-FZSE&t=643s
    public void insert(int data) {
        // Check if the linkedlist is empty or not.
        // If empty, create a head node
        // else, traverse the linkedlist till you reach the end node, and then append
        // the new data Node to the end
        Node node = new Node();
        node.data = data;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void remove(int index) {
        // remove the element at index
        Node node = head;
        if (index == 0) {
            head = node.next;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
    }

    public void show() {
        // traverse the linked list and print out each node's data
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.remove(0);
        list.show();
    }
}
