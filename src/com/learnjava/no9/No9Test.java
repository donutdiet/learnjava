package com.learnjava.no9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class No9Test extends No9 {

    @Test
    public void noNinesInList() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        remove9(list);
        assertEquals(0, list.get(0));
    }

    @Test
    public void removeOneNine() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(19, 3));
        remove9(list);
        assertEquals(3, list.get(0));
    }

    @Test
    public void removeMultipleNines() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(9, 9, 1, 29));
        remove9(list);
        assertEquals(1, list.get(0));
    }

    @Test
    public void onlyNineInListShouldThrowIndexOutOfBoundsException() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(9, 19, 29, 39, 49));
        remove9(list);
        assertTrue(list.isEmpty());
    }

}