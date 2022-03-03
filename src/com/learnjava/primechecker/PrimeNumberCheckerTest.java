package com.learnjava.primechecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumberCheckerTest {

    @Test
    public void seventyOneShouldBePrime() {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        assertEquals(true, checker.checkPrimeNumber(71));
    }

    @Test
    public void fortyShouldNotBePrime() {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        assertEquals(false, checker.checkPrimeNumber(40));
    }

    @Test
    public void oneShouldBePrime() {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        assertEquals(true, checker.checkPrimeNumber(1));
    }

    @Test
    public void zeroShouldReturnIllegalArgumentException() {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    checker.checkPrimeNumber(0);
                });
    }

    @Test
    public void negativeOneShouldReturnIllegalArgumentException() {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    checker.checkPrimeNumber(-1);
                });
    }
}