package kent.co871;

public class Main {

    public enum Season {
        SPRING(1),
        SUMMER(2),
        AUTUMN(3),
        WINTER(4);

        private final int quarter;

        Season(int quarter) {
            this.quarter = quarter;
        }

        public int getQuarter() {
            return quarter;
        }
    }

    public static void main(String[] args) {

        Season currentSeason = Season.AUTUMN;

        // compare enum values
        if (currentSeason == Season.AUTUMN) {
            System.out.println("It is Autumn.");
        }

        // iterate all enum values
for (Season season : Season.values()) {
    var info = season.name() + " in quarter " + season.getQuarter();
    System.out.println(info);
}

        System.out.println(getWeather(currentSeason));

    }

    private static String getWeather(Season season) {

        switch (season) {
            case SPRING:
                return "It's breezy!";
            case SUMMER:
                return "It’s sunny!";
            case AUTUMN:
                return "It’s rainy!";
            case WINTER:
                return "It’s chilly!";
        }
        return "None";
    }
}
