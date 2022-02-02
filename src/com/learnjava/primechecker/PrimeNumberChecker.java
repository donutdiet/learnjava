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
        return false;
    }

    public static void main(String[] args) {
        PrimeNumberChecker pmc = new PrimeNumberChecker();
        pmc.checkPrimeNumber(71);
        pmc.checkPrimeNumber(100);
    }
}
