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
    public void removeNodeFromEmptyLinkedListShouldReturnNullPointerException() {
        LinkedList list = new LinkedList();
        assertThrows(NullPointerException.class,
                () -> {
                    list.remove(0);
                });
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
}
