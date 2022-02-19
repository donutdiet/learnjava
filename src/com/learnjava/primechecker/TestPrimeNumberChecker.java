package com.learnjava.primechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestPrimeNumberChecker {

    @Test
    public void test() {
        PrimeNumberChecker pmc = new PrimeNumberChecker();
        assertTrue(pmc.checkPrimeNumber(71) == true);
        assertTrue(pmc.checkPrimeNumber(40) == false);
    }
}
