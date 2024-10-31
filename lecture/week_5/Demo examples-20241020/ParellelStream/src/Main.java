import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        var num = 100_000_000;

        var nums = Stream.iterate(1L, i -> i + 1)
                         .limit(num)
                         .toList();

        // measure performance
        //version 1
        var startTime = System.nanoTime();
        long sum = nums.stream()
                      .reduce(0L, Long::sum);
        var stopTime = System.nanoTime();
        print("Without parallel: ", stopTime, startTime, sum);

        // version 2
        startTime = System.nanoTime();
        sum = nums.stream()
                  .parallel()
                  .reduce(0L, Long::sum);
        stopTime = System.nanoTime();
        print("With parallel - using nums.stream: ", stopTime, startTime, sum);

        // version 3
        startTime = System.nanoTime();
        sum = LongStream.rangeClosed(1, num)  // no need for autoboxing so much faster
                        .parallel()
                        .reduce(0L, Long::sum);
        stopTime = System.nanoTime();
        print("With parallel - using LongStream: ", stopTime, startTime, sum);
    }

    static private void print(String msg, long stopTime, long startTime, long sum) {

        System.out.println("\nsum=" + sum);
        System.out.printf(msg + " %.3f milliseconds", (stopTime - startTime) * 1e-6);
        System.out.println();
    }
}