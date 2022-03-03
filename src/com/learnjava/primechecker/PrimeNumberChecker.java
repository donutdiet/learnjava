package com.learnjava.primechecker;

/**
 * Check if a given integer is a prime number
 */
public class PrimeNumberChecker {

    // For a given integer i, if there exists another integer j (j < i)
    // if i % j == 0, i is not a prime number
    // otherwise i is a prime number
    public boolean checkPrimeNumber(int num) {

        // Check for negative number for exception
        if (num <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumberChecker pmc = new PrimeNumberChecker();
        System.out.println(pmc.checkPrimeNumber(71));
        System.out.println(pmc.checkPrimeNumber(100));
        System.out.println(pmc.checkPrimeNumber(-15));
    }
}
