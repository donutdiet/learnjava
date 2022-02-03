package com.learnjava.primechecker;

import com.learnjava.reversestring.ReverseString;

/**
 * Check if a given integer is a prime number
 */
public class PrimeNumberChecker {

    // For a given integer i, if there exists another integer j (j < i)
    // if i % j == 0, i is not a prime number
    // otherwise i is a prime number
    public boolean checkPrimeNumber(int num) {
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
    }
}
