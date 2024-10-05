package first;

import java.util.Random;

public class First {

   static int randomInt;

    public static void main(String[] args) {
        Random gen = new Random();
        randomInt = gen.nextInt();

        String message = "A random number: ";

        System.out.println(message + randomInt);
    }
}
