package stevenNavarrette;

import java.util.Scanner;

public class ISBN13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 12 digits of an ISBN-13 number as a string: ");
        String input = scanner.nextLine().trim(); // Read input and remove any extra spaces using trim() method from scanner library

        boolean isCorrectLength = input.length() == 12; //setting boolean type variable equal to condition that checks if the input length is exactly 12 digits
        boolean isAllDigits = input.matches("\\d{12}"); //setting boolean type variable equal to condition that check if the input consists of exactly 12 digits using matches() method and regex pattern

        if (!isCorrectLength || !isAllDigits) { //checks if either(||) negated(!) result is true
            System.out.println("invalid input");
            return; //exits
        }

        int checksum = calculateChecksum(input); //calculate checksum

        String isbn13 = input + checksum; //put the appended checksum into a variable that is the ISBN-13 number

        System.out.println("The ISBN-13 number is: " + isbn13); //display ISBN-13 number
    }

    //calculate the checksum for the ISBN-13 number
    private static int calculateChecksum(String input) {
        int sum = 0;

        for (int i = 0; i < 12; i++) { //for loop through each digit of the input

            int digit = Character.getNumericValue(input.charAt(i)); //convert character at i to an integer using getNumericValue() method and .charAt() method

            if (i % 2 == 0) { //if the position is even add it to sum
                sum += digit; //add digit for odd positions
            } else {
                sum += 3 * digit; //multiply by 3 for even positions
            }
        }

        //calculate the remainder of sum when divided by 10
        int remainder = sum % 10;

        //return checksum
        return (10 - remainder) % 10;
    }
}
