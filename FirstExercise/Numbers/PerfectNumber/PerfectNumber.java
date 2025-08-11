package Numbers.PerfectNumber;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Enter a number to check whether it's perfect or not: ");

        int number = numScanner.nextInt(), sum = 0;
        numScanner.close();

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }

        if (sum == number) {
            System.out.println(number + " Is a perfect number");
        } else {
            System.out.println(number + " Is not a perfect number");
        }
    }
}