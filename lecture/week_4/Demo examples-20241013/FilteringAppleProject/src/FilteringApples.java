import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Adapted from Lambda In Action 8
public class FilteringApples {

    public static void main(String[] args) {

        var inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(250, "yellow"),
                new Apple(99, "red"),
                new Apple(101, "green")
        );

        // Print all apples
        System.out.println("All apples:");
        System.out.println(inventory);

        // Green apples
        // version 1: use filterGreenApple
        System.out.println("\nGreen apples (v1):");
        System.out.println(filterGreenApple(inventory));

        // version 2: use filterByColourApple
        System.out.println("\nGreen apples (v2):");
        System.out.println( filterByColourApple(inventory, "green") );

        // Green and heavy apples
        // version 1: use filterByCWApple
        System.out.println("\nGreen and heavy apples (v1):");
        System.out.println( filterByCWApple(inventory, "green", 150));

        // Green apples
        // version 3: use filterApple
        System.out.println("\nGreen apples( (v3):");
        System.out.println( filterApple(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.color().equals("green");
            }
        }));

        // Green and heavy apples
        // version 2: use filter
        System.out.println("\nGreen and heavy apples (v2):");
        System.out.println( filter(inventory, new Predicate<>() {
            @Override
            public boolean test(Apple a) {
                return a.color().equals("green") && a.weight() > 150;
            }
        }));

        // use lambda
        System.out.println( filter(inventory,
                    a -> a.color().equals("green") && a.weight() > 150
        ));

        // Green and heavy apples
        // Version 3: use LogicalAndPredicate
        System.out.println("\nGreen and heavy apples (v3):");
        Predicate<Apple> redPred = new AppleColourPredicate("green");
        Predicate<Apple> heavyPred = new AppleWeightPredicate(150);
        System.out.println( filter(inventory, new LogicalAndPredicate(redPred, heavyPred)));
    }

    /**
     * 1st attempt (Java 7)
     * Returns green apples only
     *
     * @param inv List of Apple
     * @return List of Apple
     */
    public static List<Apple> filterGreenApple(List<Apple> inv){
        var result = new ArrayList<Apple>();
        for(var a : inv){
            if(a.color().equals("green")){
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 2nd attempt (Java 7)
     * filter apples by colour
     *
     * @param inv List of Apple
     * @param colour  A given colour
     * @return List of Apple
     */
    public static List<Apple> filterByColourApple(List<Apple> inv, String colour){
        var result = new ArrayList<Apple>();
        for(var a : inv){
            if(a.color().equals(colour)){
                result.add(a);
            }
        }
        return result;
    }

    /**
     *  Filtering apples by a given weight
     *
     * @param inv   List of Apple
     * @param weight   A given weight
     * @return List of Apple
     */
    public static List<Apple> filterByWApple(List<Apple> inv, int weight) {
        var result = new ArrayList<Apple>();
        for (var a : inv) {
            if (a.weight() > weight) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Filtering apples by a given colour and weight
     *
     * @param inv    List of Apple
     * @param colour  A given colour
     * @param weight A given weight
     * @return List of Apple
     */
    public static List<Apple> filterByCWApple(List<Apple> inv, String colour, int weight) {
        var result = new ArrayList<Apple>();
        for (var a : inv) {
            if (a.color().equals(colour) && (a.weight() > weight)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 3rd attempt (Java 7)
     * Define an interface with a single abstract method, test
     *
     */
    public interface ApplePredicate {
        boolean test(Apple a);
    }

    /**
     * Predicate for red apples
     */
    public static class RedApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.color().equals("red");
        }
    }

    /**
     * Predicate for heavy apples
     */
    public static class HeavyApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.color().equals("red");
        }
    }

    /**
     * Predicate for red and heavy apples
     */
    public static class RedAndHeavyApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.color().equals("red") && a.weight() > 150;
        }
    }

    /**
     * More generic
     * 
     * Predicate for a given apple colour
     * e.g. new AppleColourPredicate("red")
     */
    public static class AppleColourPredicate implements Predicate<Apple> {
        private final String colour;
        public AppleColourPredicate(String colour) {
            this.colour = colour;
        }

        @Override
        public boolean test(Apple a) {
            return a.color().equals(colour);
        }
    }

    /**
     * Predicate for a given apple weight
     * e.g. new AppleWeightPredicate(150)
     *
     */
    public static class AppleWeightPredicate implements Predicate<Apple> {
        private final int threshold;
        public AppleWeightPredicate(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public boolean test(Apple a) {
            return a.weight() > threshold;
        }
    }

    /**
     * Predicate for logical and between 2 given predicates
     * e.g. new AppleAndPredicate(new AppleColourPredicate("red"),
     *                            new AppleWeightPredicate(150))
     *
     */
    public static class LogicalAndPredicate implements Predicate<Apple> {
        private final Predicate<Apple> predA;
        private final Predicate<Apple> predB;
        public LogicalAndPredicate(Predicate<Apple> predA, Predicate<Apple> predB) {
            this.predA = predA;
            this.predB = predB;
        }

        @Override
        public boolean test(Apple a) {
            return predA.test(a) && predB.test(a);
        }
    }

    /**
     * 4th attempt  (Java 8)
     * Use Java functional interface Predicate
     *
     * @param inv List of Apple
     * @param p   ApplePredicate
     * @return    List of Apple
     */
    public static List<Apple> filterApple(List<Apple> inv, ApplePredicate p) {
        var result = new ArrayList<Apple>();
        for (var a : inv) {
            if (p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Filter for a generic class T
     *
     * @param inv List of T
     * @param p   Predicate<T>
     * @param <T> Parameter type T
     * @return List of T
     */
    public static <T> List<T> filter(List<T> inv, Predicate<T> p) {
        var result = new ArrayList<T>();
        for (var a : inv) {
            if (p.test(a)) {
                result.add(a);
            }
        }
        return result;
    }
}