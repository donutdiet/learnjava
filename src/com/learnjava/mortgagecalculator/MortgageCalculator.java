package com.learnjava.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

/*
   The formula for Mortgage Payment is as follows:
   M = P [{r(1+r)^n}/{(1+r)^n – 1}]

   Where
   M = Monthly payment
   P = principal
   r = rate (annual interest rate)
   n = number of monthly payment

   Error Checking not implemented
 */
public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter Principal Amount: ");
        double principle = reader.nextDouble();

        System.out.print("Annual Interest Rate as decimal: ");
        double rate = reader.nextDouble();
        double monthlyRate = rate / 12;

        System.out.print("Period (Years): ");
        int months = reader.nextInt();
        months *= 12;

        double mortgage = principle * monthlyRate;
        mortgage *= Math.pow(1 + monthlyRate, months);
        mortgage /= (Math.pow(1 + monthlyRate, months) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage: " + currency.format(mortgage));

        reader.close();
    }
}
