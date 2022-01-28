package com.learnjava.leetcode.twosum;

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
