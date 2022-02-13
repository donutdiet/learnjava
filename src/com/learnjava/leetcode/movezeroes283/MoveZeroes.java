package com.learnjava.leetcode.movezeroes283;

import java.util.Arrays;

/**
 * Leetcode 283
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveZeroes {

    // implementation 1
    // You must do the moving in place without making a copy of the array
    public int[] moveZeroesInPlace(int[] nums) {
        return null;
    }

    public int[] moveZeroesInplace2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    // implementation 2
    // making a copy of the array is allowed
    public int[] moveZeroes(int[] nums) {

        // create the result array and fill it with 0
        int[] resultArray = new int[nums.length];
        Arrays.fill(resultArray, 0);

        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                resultArray[position] = nums[i];
                position++;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] result1 = mz.moveZeroes(new int[] {0,1,0,3,12});
        System.out.println(Arrays.toString(result1));

        int[] result2 = mz.moveZeroes(new int[] {0});
        System.out.println(Arrays.toString(result2));

        int[] result3 = mz.moveZeroesInPlace(new int[] {0,1,0,3,12});
        System.out.println(Arrays.toString(result3));

        int[] result4 = mz.moveZeroesInPlace(new int[] {0});
        System.out.println(Arrays.toString(result4));

        int[] result5 = mz.moveZeroesInplace2(new int[] {0,1,0,3,12});
        System.out.println(Arrays.toString(result5));
    }
}
