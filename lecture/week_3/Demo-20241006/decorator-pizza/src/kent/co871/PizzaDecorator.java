package kent.co871;

import java.util.Set;

public abstract class PizzaDecorator implements Pizza {
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void decorate() {
        pizza.decorate();
        System.out.println("   Add toppings: " + getToppings());
    }

    public abstract Set<String> getToppings();

}
