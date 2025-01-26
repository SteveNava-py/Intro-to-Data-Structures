package stevenNavarrette;

import java.util.Scanner;

public class PayrollStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //this creates an object of Scanner to read user input using a method from Scanner library

        System.out.print("Enter the employee's name: ");
        String employeeName = scanner.nextLine(); //this is a string variable set equal to a scanner method used to read line of text from user input

        System.out.print("Enter the number of hours worked in a week: ");
        double hoursWorked = scanner.nextDouble();

        System.out.print("Enter the hourly pay rate: ");
        double hourlyPayRate = scanner.nextDouble();

        System.out.print("Enter the federal tax withholding rate (as a percentage): ");
        double federalTaxRate = scanner.nextDouble() / 100;

        System.out.print("Enter the state tax withholding rate (as a percentage): ");
        double stateTaxRate = scanner.nextDouble() / 100;

        //calculate gross pay
        double grossPay = hoursWorked * hourlyPayRate;

        //calculate tax withheld
        double federalTaxWithheld = grossPay * federalTaxRate;
        double stateTaxWithheld = grossPay * stateTaxRate;

        //calculate net pay
        double netPay = grossPay - federalTaxWithheld - stateTaxWithheld;

        //print payroll statement
        System.out.println("\npayroll statement:");
        System.out.println("employee's name: " + employeeName);

        //these printf statements take an argument and format them using %.2f which moves numbers two decimal places and /n moves the next statement to the next line
        System.out.printf("hours worked: %.2f hours\n", hoursWorked);
        System.out.printf("hourly pay rate: $%.2f\n", hourlyPayRate);
        System.out.printf("gross pay: $%.2f\n", grossPay);
        System.out.printf("federal tax withheld: $%.2f\n", federalTaxWithheld);
        System.out.printf("state tax withheld: $%.2f\n", stateTaxWithheld);
        System.out.printf("net pay: $%.2f\n", netPay);

    }
}

