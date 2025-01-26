package stevenNavarrette;

import java.util.Scanner; // this line inputs the scanner library to get user input

public class DistanceFormula {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in); // this creates the scanner object for user input

        System.out.print("enter x1: "); //this takes the coordinate from the user
        double x1 = input.nextDouble(); //this uses the double keyword to make a variable that can hold a floating point number
                                        //input.nextDouble() is a method from Scanner to read the next input as a floating point
        System.out.print("enter y1: ");
        double y1 = input.nextDouble();
        System.out.print("enter x2: ");
        double x2 = input.nextDouble();
        System.out.print("enter y2: ");
        double y2 = input.nextDouble();

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); //this is the geometry distance formula using methods from Scanner
        System.out.println("distance = " + distance); //this displays the distance

    }
}
