package com.learnjava.leetcode.majorityelement169;

/**
 * Leetcode #169
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] a = {3,2,3};
        System.out.println(me.majorityElement(a));

        int[] b = {2,2,1,1,1,2,2};
        System.out.println(me.majorityElement(b));

        int[] c = {1 , 1 , 2 , 2 , 1 , 2 , 2};
        System.out.println(me.majorityElement(c));
    }
}
