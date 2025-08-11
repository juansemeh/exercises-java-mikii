package Frequence;

import java.util.Scanner;

public class FrequenceOfEvenAndOdd {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int evenCount = 0;
        int oddCount = 0;
        
        System.out.println("Enter 10 numbers separated by spaces or commas:");
        String input = numScanner.nextLine();
        
        String[] numbers = input.replace(",", " ").trim().split("\\s+");
        
        if (numbers.length != 10) {
            System.out.println("Please enter exactly 10 numbers.");
            numScanner.close();
            return;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            try {
                int number = Integer.parseInt(numbers[i]);
                
                if (number % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: '" + numbers[i] + "' is not a valid number.");
                numScanner.close();
                return;
            }
        }
        
        System.out.println("\nResults:");
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
        
        numScanner.close();
    }
}
