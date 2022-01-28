package com.learnjava.leetcode.twosum;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class Twosum {
    public static int[] wow(int[] array, int target) {
        int[] result = new int[2];
        for(int i=0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[i] + array[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        int target = 9;
        int[] result = wow(test, target);
        System.out.println(result[0] + " " + result[1]);

        int[] test2 = {3,2,4};
        int target2 = 6;
        int[] result2 = wow(test2, target2);
        System.out.println(result2[0] + " " + result2[1]);

        int[] test3 = {3, 3};
        int target3 = 6;
        int[] result3 = wow(test3, target3);
        System.out.println(result3[0] + " " + result3[1]);

    }
}
