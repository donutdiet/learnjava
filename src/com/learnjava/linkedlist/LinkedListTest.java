package com.learnjava.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void addOneNodeToEmptyLinkedList() {
        LinkedList list = new LinkedList();
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    public void addListOfIntegersToEmptyLinkedListWithAddAll() {
        LinkedList list = new LinkedList();
        int[] nums = { 1, 2, 3, 4, 5 };
        list.addAll(nums);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }

    @Test
    public void removeNodeFromEmptyLinkedListShouldThrowIndexOutOfBoundsException() {
        LinkedList list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.remove(0));
    }

    @Test
    public void removeFirstNodeFromLinkedList() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
    }

    @Test
    public void removeLastNodeFromLinkedList() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.remove(1);
        assertEquals(1, list.get(0));
    }

    @Test
    public void indexGreaterThanSizeShouldThrowIndexOutOfBoundsException() {
        LinkedList list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(1));
    }

    @Test
    public void testEmptyLinkedList() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIndexOf() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, list.indexOf(1));
    }

    @Test
    public void testLastIndexOf() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        assertEquals(3, list.lastIndexOf(1));
    }
}
