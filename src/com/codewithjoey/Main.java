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
        Scanner scanner = new Scanner(System.in); //scanner for user input

        System.out.print("how much do u want to take out: ");
        int principle = scanner.nextInt(); //amount for loan
        System.out.print("what is your interest rate: ");
        double interestRate = scanner.nextDouble() / 100; //annual rate divided by 100 for percent
        System.out.println("Your calculated interest rate is: " + interestRate);
        double monthlyRate = interestRate / 12; //annual rate divided by 12 months for monthly
        System.out.println("Your calculated monthly rate is: " + monthlyRate);
        System.out.print("How many years do u need the loan for: ");
        int period = scanner.nextInt() * 12; // how long user need loan for
        // monthly rate *  1 + monthly rate to the power of the length the user need the loan for
        double interestResultTop = monthlyRate * (Math.pow(1 + monthlyRate, period));
        //divide interest rate by 1 + monthly rate to the power of the length, and minus 1
        double interestResult = interestResultTop / (Math.pow(1 + monthlyRate, period) - 1);
        // amount for loan multiple interest result to get monthly mortgage
        double mortgage = principle * interestResult;
        String result = NumberFormat.getCurrencyInstance().format(mortgage); //convert mortgage to a currency format
        System.out.println("Your monthly mortgage is " + result);





    }
}
