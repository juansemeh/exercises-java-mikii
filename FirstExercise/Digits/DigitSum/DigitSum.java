package Digits.DigitSum;

import java.util.Scanner; 

public class DigitSum {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Enter a number to add its digits: ");

        int number = numScanner.nextInt(), sum = 0;
        numScanner.close();
        
        for(; number != 0; number /= 10) {
            sum += number %  10; 
        }
        System.out.println("Sum of digits: " + sum);
    }
}