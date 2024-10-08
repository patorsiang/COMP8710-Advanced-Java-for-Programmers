package kent.co871;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nBasic pizza:");
        var basic = new BasicPizza();
        basic.decorate();

        System.out.println("\nPepperoni pizza:");
        var pepperoni = new PepperoniPizza(basic);
        pepperoni.decorate();

        System.out.println("\nCombo pizza:");
        var combo = new HawaiianPizza(pepperoni);
        combo.decorate();
    }
}
