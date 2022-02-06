package com.learnjava.multiplicationtable;

/**
 * to generate a multiplication table of up to size 9 * 9
 */
public class MultiplicationTable {

    public void printMultiplicationTable(int tableSize) {
        for (int i = 0; i <= tableSize; i++) {
            if (i == 0) {
                System.out.print("        ");
                continue;
            }
            System.out.printf("%4d", i);
        }
        System.out.print("\n");
        System.out.println("-".repeat(tableSize * 4 + 10));
        for (int i = 1; i <= tableSize; i++) {
            for (int j = 0; j <= tableSize; j++) {
                if (j == 0) {
                    System.out.printf("%4d", i);
                    System.out.print("   |");
                    continue;
                }
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MultiplicationTable mt = new MultiplicationTable();
        mt.printMultiplicationTable(3);
        mt.printMultiplicationTable(5);
        mt.printMultiplicationTable(9);
    }
}
