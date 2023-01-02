package com.learnjava.pseudoscience;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Prompts the user for any positive real number, mu, and four other positive
 * real numbers, a/b/c/d, not equal to one. Then, using the de Jager formula,
 * approximates the user's mu with 17 constants as exponents. The closest
 * result, exponents used, and error are returned to the user.
 *
 * @author Jerry Wang
 *
 */
public final class ABCDGuesser2 {
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP1 = -5.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP2 = -4.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP3 = -3.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP4 = -2.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP5 = -1.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP6 = -1.0 / 2.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP7 = -1.0 / 3.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP8 = -1.0 / 4.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP9 = 0.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP10 = 1.0 / 4.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP11 = 1.0 / 3.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP12 = 1.0 / 2.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP13 = 1.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP14 = 2.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP15 = 3.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP16 = 4.0;
    /**
     * constant used as an exponent to approximate the user's mu.
     */
    private static final double EXP17 = 5.0;
    /**
     * value to initialize the lowestError variable.
     */
    private static final double INITIAL_ERROR = 1000.0;
    /**
     * how many decimals to round to when calculating result and error.
     */
    private static final int DECIMAL_ROUNDING = 4;

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     *
     * @requires user input from the console
     *
     * @ensures <pre>
     * returns a positive double
     * </pre>
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean isPositive = false;
        boolean isDouble = false;
        double userDouble = 0.0;
        while (!isDouble && !isPositive) {
            out.print("Enter a positive double: ");
            String userString = in.nextLine();
            if (FormatChecker.canParseDouble(userString)) {
                userDouble = Double.parseDouble(userString);
                if (userDouble > 0.0) {
                    isPositive = true;
                }
            }
        }
        return userDouble;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     *
     * @requires user input from the console
     *
     * @ensures <pre>
     * returns a positive double not equal to one
     * </pre>
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean isPositive = false;
        boolean isDouble = false;
        boolean isOne = true;
        double userDoubleNotOne = 0.0;
        while (!isDouble && !isPositive && isOne) {
            out.print("Enter a positive double (not 1): ");
            String userString = in.nextLine();
            if (FormatChecker.canParseDouble(userString)) {
                userDoubleNotOne = Double.parseDouble(userString);
                if (userDoubleNotOne > 0.0 && userDoubleNotOne != 1) {
                    isPositive = true;
                    isOne = false;
                }
            }
        }
        return userDoubleNotOne;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        double mu = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        double[] constants = { EXP1, EXP2, EXP3, EXP4, EXP5, EXP6, EXP7, EXP8,
                EXP9, EXP10, EXP11, EXP12, EXP13, EXP14, EXP15, EXP16, EXP17 };
        double lowestError = INITIAL_ERROR;
        double tempError;

        double bestResult = -1;
        double tempResult;

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        for (int indexW = 0; indexW < constants.length; indexW++) {
            for (int indexX = 0; indexX < constants.length; indexX++) {
                for (int indexY = 0; indexY < constants.length; indexY++) {
                    for (int indexZ = 0; indexZ < constants.length; indexZ++) {
                        tempResult = Math.pow(w, constants[indexW])
                                * Math.pow(x, constants[indexX])
                                * Math.pow(y, constants[indexY])
                                * Math.pow(z, constants[indexZ]);
                        tempError = (Math.abs(mu - tempResult)) / mu;
                        if (tempError < lowestError) {
                            lowestError = tempError;
                            bestResult = tempResult;
                            a = constants[indexW];
                            b = constants[indexX];
                            c = constants[indexY];
                            d = constants[indexZ];
                        }
                    }
                }
            }
        }

        out.print("\nclosest result: ");
        out.println(bestResult, DECIMAL_ROUNDING, false);
        out.print("lowest error: ");
        out.println(lowestError, DECIMAL_ROUNDING, false);
        out.println("a: " + a);
        out.println("b: " + b);
        out.println("c: " + c);
        out.println("d: " + d);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
