import java.util.*;

public class Main {
    public static void main(String[] args) {
        var myList = Arrays.asList(3,2,5,1,6,4);

        // ascending
        myList.sort(Integer::compare);

        System.out.println(myList);

        // descending

        myList.sort((a, b) -> Integer.compare(b, a));

        System.out.println(myList);

        // Sort even numbers first and then odd numbers
        myList.sort((a, b) -> {
            // Compare based on even or odd
            if (a % 2 == 0 && b % 2 != 0) {
                return -1; // `a` is even, `b` is odd, `a` goes before `b`
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;  // `a` is odd, `b` is even, `b` goes before `a`
            } else {
                return Integer.compare(a, b); // Both are even or both are odd, compare normally
            }
        });

        System.out.println(myList);

    }
}