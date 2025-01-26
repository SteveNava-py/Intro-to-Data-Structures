package stevenNavarrette;

import java.util.Scanner;

public class ComputeTax {
    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter filing status
        System.out.println("(0-single filer, 1-married jointly or " +
                "qualifying widow(er), 2-married separately, 3-head of " +
                "household)");
        System.out.print("Enter the filing status: ");
        int status = input.nextInt();

        // Prompt the user to enter taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        //compute tax using U.S. federal income tax rates for 2024
        //tax numbers from textbook were from 2009
        double tax = 0;

        double n = 11000 * 0.10 + (44725 - 11000) * 0.12 +
                (income - 44725) * 0.22;
        double n1 = 11000 * 0.10 + (44725 - 11000) * 0.12 +
                (95375 - 44725) * 0.22 + (income - 95375) * 0.24;
        double n2 = 11000 * 0.10 + (44725 - 11000) * 0.12 +
                (95375 - 44725) * 0.22 + (182100 - 95375) * 0.24 +
                (income - 182100) * 0.32;
        double n3 = 11000 * 0.10 + (44725 - 11000) * 0.12 +
                (95375 - 44725) * 0.22 + (182100 - 95375) * 0.24 +
                (231250 - 182100) * 0.32 + (income - 231250) * 0.35;

        //compute tax for single filers
        if (status == 0) {
            if (income <= 11000)
                tax = income * 0.10;
            else if (income <= 44725)
                tax = 11000 * 0.10 + (income - 11000) * 0.12;
            else if (income <= 95375)
                tax = n;
            else if (income <= 182100)
                tax = n1;
            else if (income <= 231250)
                tax = n2;
            else if (income <= 578125)
                tax = n3;
            else
                tax = 11000 * 0.10 + (44725 - 11000) * 0.12 +
                        (95375 - 44725) * 0.22 + (182100 - 95375) * 0.24 +
                        (231250 - 182100) * 0.32 + (578125 - 231250) * 0.35 +
                        (income - 578125) * 0.37;
        }

        //compute tax for married filing jointly
        else if (status == 1) {
            if (income <= 22000)
                tax = income * 0.10;
            else if (income <= 89450)
                tax = 22000 * 0.10 + (income - 22000) * 0.12;
            else if (income <= 190750)
                tax = 22000 * 0.10 + (89450 - 22000) * 0.12 +
                        (income - 89450) * 0.22;
            else if (income <= 364200)
                tax = 22000 * 0.10 + (89450 - 22000) * 0.12 +
                        (190750 - 89450) * 0.22 + (income - 190750) * 0.24;
            else if (income <= 462500)
                tax = 22000 * 0.10 + (89450 - 22000) * 0.12 +
                        (190750 - 89450) * 0.22 + (364200 - 190750) * 0.24 +
                        (income - 364200) * 0.32;
            else if (income <= 1156350)
                tax = 22000 * 0.10 + (89450 - 22000) * 0.12 +
                        (190750 - 89450) * 0.22 + (364200 - 190750) * 0.24 +
                        (462500 - 364200) * 0.32 + (income - 462500) * 0.35;
            else
                tax = 22000 * 0.10 + (89450 - 22000) * 0.12 +
                        (190750 - 89450) * 0.22 + (364200 - 190750) * 0.24 +
                        (462500 - 364200) * 0.32 + (1156350 - 462500) * 0.35 +
                        (income - 1156350) * 0.37;
        }

        //compute tax for married filing separately
        else if (status == 2) {
            if (income <= 11000)
                tax = income * 0.10;
            else if (income <= 44725)
                tax = 11000 * 0.10 + (income - 11000) * 0.12;
            else if (income <= 95375)
                tax = n;
            else if (income <= 182100)
                tax = n1;
            else if (income <= 231250)
                tax = n2;
            else if (income <= 578125)
                tax = n3;
        }

        //compute tax for head of household
        else if (status == 3) {
            tax = 11000 * 0.10 + (44725 - 11000) * 0.12 + 0;
        }
        else {
            System.out.println("Error: invalid status");
            System.exit(1);
        }

        // Display tax total
        System.out.println("Tax is " + (int)(tax * 100) / 100.0);
    }
}