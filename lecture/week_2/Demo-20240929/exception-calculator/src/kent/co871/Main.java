package kent.co871;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            int num1 = getNumber();
            int num2 = getNumber();
            System.out.println("Division = " + num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Error: Divide by zero.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static int getNumber() {

        final int MAX_ATTEMPTS = 2;
        var successful = false;
        var number = 0;
        var attempts = 0;

        do {
            try {
                var scanner = new Scanner(System.in);
                System.out.print("Enter an integer: ");
                number = scanner.nextInt();
                successful = true;
            } catch (InputMismatchException e) {
                attempts++;
                System.out.println("Attempt #" + attempts);
                if (attempts == MAX_ATTEMPTS) {
                    throw new RuntimeException("Max attempts reached.");
                }
            }
        } while (!successful);
        return number;
    }

}
