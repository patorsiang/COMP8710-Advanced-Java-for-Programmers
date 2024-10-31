import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {

        var menu = Dish.menu;

        System.out.println("Names and calories of all dishes ordered by their calories:");
        menu.stream()
            .sorted(Comparator.comparing(Dish::calories))
            .forEach(d -> System.out.println(d.name() + ": " + d.calories()));

        System.out.println("\nDishes with calories < 400");
        getLowCaloricDishesNames(menu).forEach(System.out::println);

        System.out.println("\nDishes with calories > 500");
        menu.stream()
            .filter(d -> {
                System.out.println("  Filtering: " + d.name() + " " + d.calories());
                return d.calories() > 500;
            })
            .map(d -> {
                System.out.println("  Mapping: " + d.name());
                return d.name();
            })
            .limit(3)
            .forEach(d -> System.out.println("Dish: " + d));

        System.out.println("\nUse peek instead:");
        menu.stream()
            .peek(d -> System.out.println("Starting: " + d))
            .filter(d -> d.calories() > 500)
            .peek(d -> System.out.println("  Filtering: " + d.name() + " " + d.calories()))
            .map(Dish::name)
            .peek(d -> System.out.println("  Mapping: " + d))
            .limit(3)
            .peek(d -> System.out.println("  Limited: " + d))
            .forEach(d -> System.out.println("Dish: " + d));

        // Demo: Find a vegetarian dish with calories < 150
        var namesOfLightVegDishes = Dish.menu.stream()
                                             .filter(Dish::isVegetarian)
                                             .filter(d -> d.calories() < 150)
                                             .map(Dish::name)
                                             .findAny();
        if (namesOfLightVegDishes.isPresent()) {
            System.out.print("Found: ");
        }
        System.out.println(namesOfLightVegDishes.orElse("Not found."));

        // Demo: Print the average number of calories in the menu
        var total = Dish.menu.stream()
                             .map(Dish::calories)
                             .reduce(0, Integer::sum);
        System.out.println("Average calories: " + String.format("%.2f", 1.0 * total / Dish.menu.size()));

        // Demo: Print a short menu (a list of dish names separated by “,”)
        var shortMenu = Dish.menu.stream()
                                 .map(Dish::name)
                                 .reduce("", (a, b) -> a + b + ", ");
        System.out.println(shortMenu);

        // use methods of Collectors
        var numberOfDishes = menu.stream()
                                 .collect(counting()); // same as menu.stream().count();
        System.out.println("Number of dishes: " + numberOfDishes);

        var averageCalories = menu.stream().collect(averagingInt(Dish::calories));
        System.out.println("Average calories: " + String.format("%.2f", averageCalories));

        String shortMenuCommaSeparated = menu.stream()
                                             .map(Dish::name)
                                             .collect(joining(", "));
        System.out.println(shortMenuCommaSeparated);

        var dishCaloriesComparator = Comparator.comparingInt(Dish::calories);
        var mostCalorieDish = menu.stream()
                                  .max(dishCaloriesComparator);
        mostCalorieDish.ifPresent(System.out::println);

        // group dishes by type
        Map<Dish.Type, List<Dish>> groupedDishes = menu.stream()
                                                       .collect(groupingBy(Dish::type));
        groupedDishes.forEach((k, v) -> {
            System.out.println(k + ": ");
            v.forEach(dish -> System.out.println("  " + dish));
        });
    }

    public static List<String> getLowCaloricDishesNames(List<Dish> dishes) {

        return dishes.stream()
                     .filter(d -> d.calories() < 400)
                     .sorted(Comparator.comparing(Dish::calories))
                     .map(Dish::name)
                     .collect(Collectors.toList());     // or .toList()
    }

}