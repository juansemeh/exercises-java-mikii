package Average;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner (System.in);
        System.out.println("Enter first note: ");

        Float firstNum = numScanner.nextFloat();

        System.out.println("Enter second note: ");

        Float secondNum = numScanner.nextFloat();

        System.out.println("Enter third note: ");

        Float thirdNum = numScanner.nextFloat();
        numScanner.close();

        Float promedy = firstNum + secondNum + thirdNum / 3; 
        System.out.println("Your promedy is: " + promedy);
    }
}