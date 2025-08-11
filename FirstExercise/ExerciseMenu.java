import HelloWorld.*;
import Numbers.InvertNumbers.InvertNumbers;
import Numbers.PerfectNumber.PerfectNumber;
import Numbers.PrimeNumber.CheckPrime;
import MultipleOfThree.MultipleOfThree;
import Frequence.FrequenceOfEvenAndOdd;
import FibonacciSequence.FibonacciSequence;
import Digits.DigitCount.DigitCount;
import Digits.DigitSum.DigitSum;
import Average.Average;

import java.util.Scanner;

public class ExerciseMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("""
        ---------------------------------------------
        Please choice a program between 1 and 11:
        1. HelloWorld
        2. Inversion of a number string
        3. Check whether a number is prime or not
        4. Check whether a number is perfect or not
        5. Check the multiples of three within a given number
        6. Check the frequency of odds and evens in a string of ten numbers
        7. Check the Fibonacci sequence within a given ammount of terms
        8. Count the digits of a number
        9. Add the digits of a number
        10. Calculate the average of three notes
        11. Exit the program
        ---------------------------------------------
        """);

        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("\n--- Hello World ---");
                HelloWorld.main(new String[]{});
                break;
            case 2:
                System.out.println("\n--- Invert Numbers ---");
                InvertNumbers.main(new String[]{});
                break;
            case 3:
                System.out.println("\n--- Check Prime ---");
                CheckPrime.main(new String[]{});
                break;
            case 4:
                System.out.println("\n--- Perfect Number ---");
                PerfectNumber.main(new String[]{});
                break;
            case 5:
                System.out.println("\n--- Multiple of Three ---");
                MultipleOfThree.main(new String[]{});
                break;
            case 6:
                System.out.println("\n--- Frequency of Even and Odd ---");
                FrequenceOfEvenAndOdd.main(new String[]{});
                break;
            case 7:
                System.out.println("\n--- Fibonacci Sequence ---");
                FibonacciSequence.main(new String[]{});
                break;
            case 8:
                System.out.println("\n--- Digit Count ---");
                DigitCount.main(new String[]{});
                break;
            case 9:
                System.out.println("\n--- Digit Sum ---");
                DigitSum.main(new String[]{});
                break;
            case 10:
                System.out.println("\n--- Average ---");
                Average.main(new String[]{});
                break;
            case 11:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Choice out of scope. Please try again.");
        }
        
        scanner.close();
    }
}
