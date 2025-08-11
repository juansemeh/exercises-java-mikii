package MultipleOfThree;

import java.util.Scanner;

public class MultipleOfThree {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Choice a natural number to limit the range of multiples to check: ");

        int number = numScanner.nextInt();
        numScanner.close();
        
        for (int i = 3; i <= number; i += 3) {
            System.out.println(i);
        }
    }
}