package com.codewithjoey;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //STEPS NEEDED
        // P principal = amount of loan to get (100k)
        // annual interest rate = 6% -> (0.06/ 100)
        // R monthly interest rate = annual(0.06) / 12 -> 0.005
        // N period (years) = how long want the loan for (15 yrs) * 12 -> 180
        // then we have principle * R(0.005) * (1 + R(0.05))^ N(180) / (1 + R(0.05))^ N(180)-1
            // principle * (0.005 *(Math.pow(R(0.005), N) / (Math.pow(R(0.005), N) - 1
                //SO p * (r *(Math.pow(R, N)) / (Math.pow(R, N)) -1
                // next p * (result top / result bottom) = mortgage
        // M mortgage = calculates monthly payments and display with currency ($472.81)

        //mortgage = principle * interest rate
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
