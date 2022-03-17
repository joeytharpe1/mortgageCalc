package com.codewithjoey;

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
public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
