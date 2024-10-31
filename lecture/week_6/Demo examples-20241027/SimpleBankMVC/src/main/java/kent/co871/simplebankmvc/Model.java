package kent.co871.simplebankmvc;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Optional;

public class Model {
    private final ObservableList<Account> accounts;

    public Model() {
        accounts = FXCollections.observableArrayList();
    }

    public ObservableList<Account> getCustomers() {
        return accounts;
    }

    public int bankSize() {
        return accounts.size();
    }

    public int bankCashAssets() {
        return accounts.stream()
                       .mapToInt(Account::getBalance)
                       .sum();
    }

    public void addAccount(String name, int balance) {
        accounts.add(new Account(name, balance));
    }

    public Optional<Account> getAccount(String name) {
        return accounts.stream()
                       .filter(a -> a.getName().equals(name))
                       .findFirst();
    }

    public void removeAccount(Account a) {
        if (!accounts.contains(a)) {
            System.out.println("The account is not found.");
            return;
        }
        accounts.remove(a);
    }

    public void addAccountsListener(ListChangeListener listener) {
        accounts.addListener(listener);
    }
}