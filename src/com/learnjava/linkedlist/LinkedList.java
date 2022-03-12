package com.learnjava.linkedlist;

public class LinkedList {

    public Node head;
    private int size = 0;

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public int get(int index) {

        rangeCheck(index);

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    // If you can not figure it out, please refer to video
    // https://www.youtube.com/watch?v=SMIq13-FZSE&t=643s
    public void add(int data) {
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
        size++;
    }

    public void addAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node();
            node.data = nums[i];

            if (head == null) {
                head = node;
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = node;
            }
            size++;
        }
    }

    public void remove(int index) {

        rangeCheck(index);

        // remove the element at index
        Node node = head;
        if (index == 0) {
            head = node.next;
        }

        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        if (node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        size--;
    }

    public int indexOf(int num) {
        Node node = head;
        int index = 0;
        while (node != null) {
            if (node.data == num) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(int num) {
        Node node = head;
        int currentIndex = 0;
        int lastIndex = -1;
        while (node != null) {
            if (node.data == num) {
                lastIndex = currentIndex;
            }
            node = node.next;
            currentIndex++;
        }
        if (lastIndex != -1) {
            return lastIndex;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size > 0 ? false : true;
    }

    public int size() {
        return this.size;
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
        int[] nums = { 1, 2, 3, 4 };
        list.addAll(nums);
        list.show();
    }
}
