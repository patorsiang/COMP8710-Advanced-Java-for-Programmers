package kent.co871.simplebankmvc;

/**
 * A simple bank account
 */
public class Account {
    private static int count = 0;
    private String id;
    private final String name;
    private final int balance;

    public Account(String name, int balance) {
        count++;
        id = "Account" + count;
        this.name = name;
        this.balance = balance;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return getID() + " (" + getName() + "): " + getBalance();
    }
}