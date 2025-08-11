package Numbers.PrimeNumber;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Enter a natural number to check if it's prime: ");

        int number = numScanner.nextInt();
        numScanner.close();

        if(number % 2 == 0) {
            System.out.println("is a prime number.");
        } else {
            System.out.println("is not a prime number.");
        }
    }
}