package com.learnjava.linkedlist;

public class LinkedList {

    public Node head;

    // If you can not figure it out, please refer to video https://www.youtube.com/watch?v=SMIq13-FZSE&t=643s
    public void insert(int data) {
        // Check if the linkedlist is empty or not.
        // If empty, create a head node
        // else, traverse the linkedlist till you reach the end node, and then append the new data Node to the end
    }

    public void remove(int index) {
        // remove the element at index
    }

    public void show() {
        // traverse the linked list and print out each node's data
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
    }
}
