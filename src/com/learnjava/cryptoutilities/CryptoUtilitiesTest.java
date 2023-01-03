package com.learnjava.cryptoutilities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test // zeros
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test // routine
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test // routine
    public void testReduceToGCD_200_125() {
        NaturalNumber n = new NaturalNumber2(200);
        NaturalNumber nExpected = new NaturalNumber2(25);
        NaturalNumber m = new NaturalNumber2(125);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    //
    @Test // big number
    public void testReduceToGCD_899999823_834() {
        NaturalNumber n = new NaturalNumber2(899999823);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(834);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test // m > n
    public void testReduceToGCD_15_20() {
        NaturalNumber n = new NaturalNumber2(15);
        NaturalNumber nExpected = new NaturalNumber2(5);
        NaturalNumber m = new NaturalNumber2(20);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test // zero
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test // routine
    public void testIsEven_99() {
        NaturalNumber n = new NaturalNumber2(99);
        NaturalNumber nExpected = new NaturalNumber2(99);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test // big number
    public void testIsEven_1000000000() {
        NaturalNumber n = new NaturalNumber2(1000000000);
        NaturalNumber nExpected = new NaturalNumber2(1000000000);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    @Test // edge case
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test // num^0
    public void testPowerMod_17_0_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test // 0^num
    public void testPowerMod_0_156_11() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(156);
        NaturalNumber pExpected = new NaturalNumber2(156);
        NaturalNumber m = new NaturalNumber2(11);
        NaturalNumber mExpected = new NaturalNumber2(11);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test // big num
    public void testPowerMod_197_1565_1451() {
        NaturalNumber n = new NaturalNumber2(197);
        NaturalNumber nExpected = new NaturalNumber2(585);
        NaturalNumber p = new NaturalNumber2(1565);
        NaturalNumber pExpected = new NaturalNumber2(1565);
        NaturalNumber m = new NaturalNumber2(1451);
        NaturalNumber mExpected = new NaturalNumber2(1451);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test // bigger num
    public void testPowerMod_999999995_55555_10() {
        NaturalNumber n = new NaturalNumber2(999999995);
        NaturalNumber nExpected = new NaturalNumber2(5);
        NaturalNumber p = new NaturalNumber2(55555);
        NaturalNumber pExpected = new NaturalNumber2(55555);
        NaturalNumber m = new NaturalNumber2(10);
        NaturalNumber mExpected = new NaturalNumber2(10);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    @Test // routine
    public void testIsWitnessToCompositenes_2_10() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(12);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsWitnessToCompositenes_100_203() {
        NaturalNumber w = new NaturalNumber2(100);
        NaturalNumber n = new NaturalNumber2(203);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsWitnessToCompositenes_12_25() {
        NaturalNumber w = new NaturalNumber2(12);
        NaturalNumber n = new NaturalNumber2(25);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsWitnessToCompositenes_100_1000() {
        NaturalNumber w = new NaturalNumber2(100);
        NaturalNumber n = new NaturalNumber2(1000);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(true, result);
    }

    @Test // big number
    public void testIsWitnessToCompositenes_285_102127391() {
        NaturalNumber w = new NaturalNumber2(285);
        NaturalNumber n = new NaturalNumber2(102127391);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(false, result);
    }

    /*
     * Tests of isPrime1
     */

    @Test // edge case
    public void testIsPrime1_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsPrime1_11() {
        NaturalNumber n = new NaturalNumber2(11);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsPrime1_56() {
        NaturalNumber n = new NaturalNumber2(56);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(false, result);
    }

    @Test // routine
    public void testIsPrime1_90() {
        NaturalNumber n = new NaturalNumber2(90);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(false, result);
    }

    @Test // big number
    public void testIsPrime1_599482957() {
        NaturalNumber n = new NaturalNumber2(599482957);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(true, result);
    }

    /*
     * Tests of isPrime2
     */

    @Test // edge case
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsPrime2_11() {
        NaturalNumber n = new NaturalNumber2(11);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(true, result);
    }

    @Test // routine
    public void testIsPrime2_56() {
        NaturalNumber n = new NaturalNumber2(24);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(false, result);
    }

    @Test // routine
    public void testIsPrime2_90() {
        NaturalNumber n = new NaturalNumber2(90);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(false, result);
    }

    @Test // big number
    public void testIsPrime2_599482957() {
        NaturalNumber n = new NaturalNumber2(599482957);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals(true, result);
    }

    /*
     * Tests of generateNextLikelyPrime
     */

    @Test // edge case
    public void testGenerateNextLikelyPrime_3() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber nExpected = new NaturalNumber2(5);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test // routine
    public void testGenerateNextLikelyPrime_11() {
        NaturalNumber n = new NaturalNumber2(11);
        NaturalNumber nExpected = new NaturalNumber2(13);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test // routine
    public void testGenerateNextLikelyPrime_33() {
        NaturalNumber n = new NaturalNumber2(33);
        NaturalNumber nExpected = new NaturalNumber2(37);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test // routine
    public void testGenerateNextLikelyPrime_100() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber nExpected = new NaturalNumber2(101);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test // big number
    public void testGenerateNextLikelyPrime_128130249() {
        NaturalNumber n = new NaturalNumber2(128130249);
        NaturalNumber nExpected = new NaturalNumber2(128130251);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }
}
