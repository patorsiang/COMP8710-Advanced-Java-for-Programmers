package kent.co871;

public class BasicPizza implements Pizza {

    @Override
    public void decorate() {
        System.out.println("Pizza base with tomato and cheese.");
    }
}
