package com.learnjava.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void insertOneNodeToEmptyLinkedList() {
        LinkedList list = new LinkedList();
        list.add(1);
        assertEquals(1, list.get(0));
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
}
