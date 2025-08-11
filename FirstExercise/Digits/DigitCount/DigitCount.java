package Digits.DigitCount;

import java.util.Scanner;

public class DigitCount {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }
    
    public static void main(String[] args) {
        Scanner numScanner = new Scanner (System.in);
        System.out.println("Enter a number to count its digits: ");
        
        int num = numScanner.nextInt();
        numScanner.close();
        System.out.println("Number of digits: " + countDigits(num));
    }
}