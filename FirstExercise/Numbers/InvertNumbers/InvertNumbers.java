package Numbers.InvertNumbers;

import java.util.Scanner;

public class InvertNumbers {

    public static int reversedNumber(int reversed) {
        StringBuffer sb = new StringBuffer(String.valueOf(reversed));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
    
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("Enter a number to see how it seems reversed: ");

        int number = numScanner.nextInt();
        numScanner.close();

        System.out.println("Your number reversed is: " + reversedNumber(number));
    }
}