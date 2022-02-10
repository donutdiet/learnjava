package com.learnjava.leetcode.majorityelement169;

import java.util.HashMap;

/**
 * Leetcode #169
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
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
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], 1);
            } else {
                int count = frequencyMap.get(nums[i]);
                frequencyMap.replace(nums[i], count + 1);
                if (count + 1 > nums.length / 2) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] a = { 3, 2, 3 };
        System.out.println(me.majorityElement(a));

        int[] b = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(me.majorityElement(b));

        int[] c = { 1, 1, 2, 2, 1, 2, 2 };
        System.out.println(me.majorityElement(c));
    }
}
