package FibonacciSequence;

import java.util.Scanner; 

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Enter a number to see the Fibonacci sequence up the ammount of terms.");

        int number = numScanner.nextInt();
        numScanner.close();

        int first = 0, second = 1;

        System.out.println("Fibonacci sequence up to " + number + " terms: ");
        for (int i = 1; i <= number; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second; 
            second = next;
        }
    }
}