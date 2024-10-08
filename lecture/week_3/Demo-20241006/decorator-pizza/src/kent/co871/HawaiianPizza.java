package kent.co871;

import java.util.Set;

public class HawaiianPizza extends PizzaDecorator {
    public HawaiianPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Set<String> getToppings() {
        return Set.of("Pineapple","Ham");
    }
}
