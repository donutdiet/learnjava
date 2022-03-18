package com.learnjava.no9;

import java.util.*;

/**
 * Given a list of non-negative integers, return a list of those numbers except
 * omitting
 * any that end with 9
 *
 * no9([1,2,19]) -> [1,2]
 * no9([9,19,29,3]) -> [3]
 * no9([1,2,3]) -> [1,2,3]
 *
 * Try not to copy/crate a new list, do the transformation in-place.
 * You can come up with two methods - in place one and new list one
 */
public class No9 {

    public static List<Integer> remove9(List<Integer> numList) {
        for (int i = numList.size() - 1; i >= 0; i--) {
            int num = numList.get(i);
            while (num > 10) {
                num %= 10;
            }
            if (num == 9) {
                numList.remove(i);
            }
        }
        return numList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(9, 19, 29, 3));
        System.out.println(remove9(list));
        // System.out.println(remove9(List.of(1, 2, 19)));
        // System.out.println(remove9(List.of(9, 19, 29, 3)));
        // System.out.println(remove9(List.of(1, 2, 3)));
    }
}
