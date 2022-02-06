package com.learnjava.leetcode.twosum;

import java.util.HashMap;

public class TwoSumHashMap {
    public static int[] solver(int[] array, int target) {
        int[] solution = new int[2];
        HashMap<Integer, Integer> previous = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int difference = target - array[i];
            if (previous.containsKey(difference)) {
                solution[0] = previous.get(difference);
                solution[1] = i;
                return solution;
            }
            previous.put(array[i], i);
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] test = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = solver(test, target);
        System.out.println(result[0] + " " + result[1]);

        int[] test2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solver(test2, target2);
        System.out.println(result2[0] + " " + result2[1]);

        int[] test3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solver(test3, target3);
        System.out.println(result3[0] + " " + result3[1]);
    }
}
