import java.util.List;

public record Dish(String name, boolean isVegetarian, int calories, Type type) {

    public enum Type {
        MEAT, FISH, OTHER
    }

    @Override
    public String toString() {

        return name;
    }

    public static final List<Dish> menu
            = List.of(
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 400, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH),
            new Dish("pork", false, 800, Type.MEAT));
}